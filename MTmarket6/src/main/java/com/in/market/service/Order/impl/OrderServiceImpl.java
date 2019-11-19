package com.in.market.service.order.impl;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.in.market.dao.cart.CartDao;
import com.in.market.dao.order.OrderDao;
import com.in.market.dao.order.OrderDetailDao;
import com.in.market.pojo.order.Order;
import com.in.market.service.order.OrderService;
import com.in.market.util.OrderResult;
import com.in.market.util.ResultList;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.IOException;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String CACHE_ORDER = "cache_order_";

//    @Autowired
//    private JedisService jedisService;

    @Autowired
    private DataSourceTransactionManager transactionManager;


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartDao cartDao;
    
    @Autowired
    private com.in.market.service.cart.CartService cartService = null;

    @Autowired
    private OrderDetailDao orderDetailDao;

    /**
     * 创建订单
     * @param  jsonOrder  The jsonData about Order information
     * @return  OrderId
     * */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public OrderResult createOrder(String jsonOrder) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("createOrder");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try{
            Order order = null;
            try {
                order = MAPPER.readValue(jsonOrder,Order.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            if (order.getOrderDetails() == null || order.getOrderUser()==null || order.getOrderAddress() == null){
                return null;
            }

            //TODO 要对order进行数据校验
            for (int i = 0; i < order.getOrderDetails().size(); i++) {
                if (order.getOrderDetails().get(i) == null ||
                        (order.getOrderDetails().get(i)!= null && order.getOrderDetails().get(i).getDetailGoods() == null) ) {
                    order.getOrderDetails().remove(i);
                }
            }


//        try{
//            String orderId = UUID.randomUUID().toString().replace("-","");
            String orderId = RandomStringUtils.randomNumeric(28);
                    order.setOrderId(orderId);
            // 返回的订单数据
            OrderResult orderResult = new OrderResult(orderId,orderId.hashCode());

            //TODO
            order.setOrderDate(new Date());
            //设置订单为未付款
            order.setOrderState(1);
            //设置配送单号
            String uuidExpressNo = UUID.randomUUID().toString().replace("-","");
            order.setOrderExpressNo(uuidExpressNo);

            this.orderDao.saveOrder(order);

            //创建订单之后删除购物车
            try{
                cartService.deleteGoodsForOrderRedisCart(order);
                return orderResult;
            }catch (Exception e){
                e.printStackTrace();
            }
            return orderResult;
        }catch (Exception e){
           transactionManager.rollback(status);
           throw  e;
        }
    }

    /**
     * 通过订单ID查询订单
     * @param orderId A ID about Order
     * @return an object about Order which id is equals of param
     * */
    @Override
    public Order queryByOrderId(String orderId) {

        Order order = this.orderDao.queryOrderByOrderId(orderId);
        if (null == order){
            return null;
        }
        return order;
    }

//    //TODO
//    @Override
//    public ResultList queryListByNickName(String nickName, Integer page, Integer count) {
//        PageHelper.startPage(page,count);
//        Example example = new Example(Order.class);
//        //TODO
//        example.createCriteria().andEqualTo("",nickName);
//        List<Order> orders = this.orderMapper.selectByExample(example);
//        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);
//        return new ResultList(pageInfo.getTotal(),pageInfo.getList());
//    }

    /**
     * jsonData 里面有订单id
     * 传入订单id，要修改的订单状态的json
     * 更新订单状态
     *
     * @param jsonData The jsonData which include in a few Order information
     *
     * */
    @Override
    @Transactional
    public void changeOrderStatus(String jsonData) throws Exception{
        Order order = null;

        order = MAPPER.readValue(jsonData,Order.class);
        if (order == null || order.getOrderState() == null || order.getOrderId() == null){
            throw new Exception("参数错误！");
        }
        this.orderDao.changeOrderStatus(order);
    }

    @Override
    @Transactional
    public void changeOrderStatus2(String orderId) throws Exception{
        Order order = null;
        if (orderId == null){
            throw new Exception("参数错误！");
        }
        this.orderDao.changeOrderStatus2(orderId);
    }


    /**
     * 跟据userId查询订单
     * @param  orderUser The userId about the Order
     * @return The mapper including the number of Order objects will be return
     *
     * */
    @Override
    public ResultList queryByUserId(Integer orderUser)throws Exception {

        List<Order> orders = null;

      /*  String cacheData = jedisService.get(CACHE_ORDER +"user_" +orderUser);
        if (null == cacheData){
            synchronized (this){
                cacheData = jedisService.get(CACHE_ORDER +"user_" +orderUser);
               if (null == cacheData){
                  orders = this.orderDao.queryByUserId(orderUser);
                  this.jedisService.set(CACHE_ORDER +"user_" +orderUser,MAPPER.writeValueAsString(orders));
               }
            }
        }else{
            orders = MAPPER.readValue(cacheData,MAPPER.getTypeFactory().constructCollectionType(List.class,Order.class));
        }*/
        orders = this.orderDao.queryByUserId(orderUser);
        return new ResultList(orders.size(),orders);
            //        List<Order> orders = null;
//        orders = this.orderDao.queryByUserId(orderUser);
//        List<Order> result = new ArrayList<Order>();
//        try{
//            for(Order order : orders){
//
//                Order order1 = this.orderDao.queryOrderByOrderId(order.getOrderId());
//                if (order1 == null){
//                    order1 = order;
//                }
//                result.add(order1);
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        return new ResultList(result.size(),result);


    }

    /**
     * 跟据userId和订单的状态筛选订单
     * @param map Querying orders by userId and orderStatus ,the map include in some order information.
     * @return The mapper including the number of Order objects will be return
     * */
    @Override
    public ResultList queryOrderByUserIdAndState(Map<String,Object> map) {
        List<Order> orders = this.orderDao.queryOrderByUserIdAndState(map);
        List<Order> result = new ArrayList<Order>();
        try{
            for(Order order : orders){

                Order order1 = this.orderDao.queryOrderByOrderId(order.getOrderId());
                if (order1 == null){
                    order1 = order;
                }
                result.add(order1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResultList(result.size(),result);
    }
    /**
     * 跟据订单id删除订单
     * @param orderId
     *
     * */
    @Override
    @Transactional
    public void deleteOrderByOrderId(String orderId) {
        this.orderDetailDao.deleteOrderDetailByOrderId(orderId);
        this.orderDao.deleteOrderByOrderId(orderId);

    }

    @Override
    public ResultList queryOrderByCommuityName(String commuityName) {
        ResultList resultList = new ResultList();
        List<Order> orders = this.orderDao.queryOrderByCommuityName(commuityName);
        resultList.setRows(orders);
        resultList.setTotal(orders.size());
        return resultList;
    }


}

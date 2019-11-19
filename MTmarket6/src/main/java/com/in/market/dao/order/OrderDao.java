package com.in.market.dao.order;


import com.in.market.pojo.order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {
    //保存订单
    void saveOrder(Order order);
    //根据订单id查询订单
    Order queryOrderByOrderId(String orderId);
    //根据订单id更改订单状态
    void changeOrderStatus(Order order);

    //根据用户id查询订单列表
    List<Order> queryByUserId(Integer orderUser);

    //跟据订单状态及用户id查询订单
    List<Order> queryOrderByUserIdAndState(Map<String, Object> map);

    //根据订单id删除订单
    void deleteOrderByOrderId(String orderId);

    void changeOrderStatus2(String orderId);

   List<Order> queryOrderByCommuityName(@Param("commuityName") String commuityName);
}

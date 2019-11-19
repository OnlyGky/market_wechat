package com.in.market.controller.order;




import com.in.market.pojo.order.Order;
import com.in.market.service.order.OrderService;
import com.in.market.util.OrderResult;
import com.in.market.util.ResultList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/order")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 创建订单，返回订单号
     * */

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<OrderResult> createOrder(@RequestBody String jsonOrder){
       try{

           OrderResult orderResult = this.orderService.createOrder(jsonOrder);

           if (StringUtils.isNotEmpty(orderResult.getOrderId())){
               return ResponseEntity.ok(orderResult);
           }
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

       }catch (Exception e){
           e.printStackTrace();
       }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据订单id查询订单
     * */
    @RequestMapping(value = "/query/{orderId}",method = RequestMethod.GET)
    public ResponseEntity<Order> queryByOrderId(@PathVariable("orderId")String orderId){
        try{
            Order order =  this.orderService.queryByOrderId(orderId);
            return ResponseEntity.ok(order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }


    /**
     *
     * 修改订单状态
     *
     */
    @RequestMapping(value = "/changeOrderStatus")
    public ResponseEntity<Void> changeOrderStatus(@RequestBody String jsonData){
        try{
            this.orderService.changeOrderStatus(jsonData);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            //400 参数错误
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     *
     *将订单状态修改成待发货
     * */
    @GetMapping(value = "/changeOrderStatus2/{orderId}")
    public ResponseEntity<Void> changeOrderStatus2(@PathVariable(value = "orderId") String orderId){
        try{
            this.orderService.changeOrderStatus2(orderId);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            //400 参数错误
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }



    /**
     * *根据用户获取用户ID的所有订单
     */
    @RequestMapping(value = "/queryByUser/{orderUser}",method = RequestMethod.GET)
    public ResponseEntity<ResultList> queryOrderByUserId(@PathVariable(value = "orderUser") Integer orderUser){
        ResultList resultList = null;
        try{
            resultList = this.orderService.queryByUserId(orderUser);
            return ResponseEntity.ok(resultList);
        }catch (Exception e){
           e.printStackTrace();

       }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * *根据用户ID+订单的状态 查询订单
     */
    @RequestMapping(value = "/queryByUser/{orderUser}/{orderState}",method = RequestMethod.GET)
    public ResponseEntity<ResultList> queryOrderByUserIdAndState(@PathVariable(value = "orderUser") Integer orderUser,
                                                                 @PathVariable(value = "orderState")Integer orderState){
        ResultList resultList = null;
        Map<String,Object> map = new HashMap<>();
        map.put("orderUser",orderUser);
        map.put("orderState",orderState);
        try{
            resultList = this.orderService.queryOrderByUserIdAndState(map);
            return ResponseEntity.ok(resultList);
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据订单ID删除订单
     * */
    @RequestMapping(value = "/delete/{orderId}")
    public ResponseEntity<Void> deleteOrderByOrderId(@PathVariable(value = "orderId")String orderId){
        try{
            this.orderService.deleteOrderByOrderId(orderId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 根据订单小区号查询订单
     * */
    @GetMapping("/query/list/commuity")
    public ResponseEntity<ResultList> queryByCommuityName(String commuityName){
        try{
            ResultList resultList = orderService.queryOrderByCommuityName(commuityName);
            return ResponseEntity.ok(resultList);
        }catch (Exception e){
            e.printStackTrace();
        }
       return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }




}

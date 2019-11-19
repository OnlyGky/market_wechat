package com.in.market.service.order;


import com.in.market.pojo.order.Order;
import com.in.market.util.OrderResult;
import com.in.market.util.ResultList;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderService {
    OrderResult createOrder(String jsonOrder);

    Order queryByOrderId(String orderId);

//    ResultList queryListByNickName(String nickName, Integer page, Integer count);

    void changeOrderStatus(String jsonData) throws Exception;

    void changeOrderStatus2(String orderId) throws Exception;

    ResultList queryByUserId(Integer orderUser) throws Exception;

    ResultList queryOrderByUserIdAndState(Map<String, Object> map);

    void deleteOrderByOrderId(String orderId);


    /**
     * 根据小区号，查询订单
     * */
    ResultList queryOrderByCommuityName(@Param("commuityName") String commuityName);
}

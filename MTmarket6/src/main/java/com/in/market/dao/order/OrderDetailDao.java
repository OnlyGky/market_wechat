package com.in.market.dao.order;


import com.in.market.pojo.order.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailDao {

    OrderDetail queryOrderDetailByOrderId(String orderId);
//
//    Goods queryGoodsByOrderDetailId(Integer detail_Id);

    void deleteOrderDetailByOrderId(String orderId);

}

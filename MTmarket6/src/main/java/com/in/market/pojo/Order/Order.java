package com.in.market.pojo.order;



import com.in.market.pojo.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * 订单表
 * */
@Table(name = "`order`")
public class Order {

    //订单编号
    @Id
    @GeneratedValue(generator = "UUID")
    private String orderId;

    private Integer orderUser;

    //订单生成时间
    private Date orderDate;

    //订单总价钱
    private Double orderPrice;
    //订单状态
    /**
     * -1删除 1 待付款 2待发货 3 待收货 4待评价 5完成
     * */
    private Integer orderState;

    //订单所有者的名字
    private String orderUserName;
    //电话
    private String orderPhone;
    //地址
    private String orderAddress;
    //快递单号
    @Column(name = "order_ExpressNo")
    private String orderExpressNo;
    /**
     * 配送方式
     * */
    @Column(name = "order_dispatchType")
    private Integer orderDispatchType;



    //商品项目
    @Transient
    private List<com.in.market.pojo.order.OrderDetail> orderDetails;
    @Transient
    private User user;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderExpressNo() {
        return orderExpressNo;
    }

    public void setOrderExpressNo(String orderExpressNo) {
        this.orderExpressNo = orderExpressNo;
    }

    public Integer getOrderDispatchType() {
        return orderDispatchType;
    }

    public void setOrderDispatchType(Integer orderDispatchType) {
        this.orderDispatchType = orderDispatchType;
    }

    public List<com.in.market.pojo.order.OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<com.in.market.pojo.order.OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

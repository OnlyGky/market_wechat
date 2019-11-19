package com.in.market.util;

public class OrderResult {
    private String orderId;
    private Integer hashCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(Integer hashCode) {
        this.hashCode = hashCode;
    }

    public OrderResult() {

    }

    public OrderResult(String orderId, Integer hashCode) {

        this.orderId = orderId;
        this.hashCode = hashCode;
    }
}

package com.in.market.pojo.afterSale;

import java.util.Date;

public class AfterSale {

    private Long id;
    private String orderId;
    private Integer orderdetId;
    private Integer userId;
    private Integer goodsId;
    private String goodsName;
    private Integer count;
    private Double goodsPrice;
    private Double money;
    private Integer questType;
    private String questDesc;
    private String questImgs;
    private Date questDate;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderdetId() {
        return orderdetId;
    }

    public void setOrderdetId(Integer orderdetId) {
        this.orderdetId = orderdetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getQuestType() {
        return questType;
    }

    public void setQuestType(Integer questType) {
        this.questType = questType;
    }

    public String getQuestDesc() {
        return questDesc;
    }

    public void setQuestDesc(String questDesc) {
        this.questDesc = questDesc;
    }

    public String getQuestImgs() {
        return questImgs;
    }

    public void setQuestImgs(String questImgs) {
        this.questImgs = questImgs;
    }

    public Date getQuestDate() {
        return questDate;
    }

    public void setQuestDate(Date questDate) {
        this.questDate = questDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package com.in.market.dto;

import com.in.market.pojo.goods.GoodsDetail;

import java.io.Serializable;

public class GoodsAssessAndDetail implements Serializable {


    private static final long serialVersionUID = 7849388644736122574L;
    private GoodsDetail goodsDetail;
    private DiscountGoods discountGoods;
    private Integer  assess;

    public GoodsAssessAndDetail() {
    }

    public GoodsAssessAndDetail(GoodsDetail goodsDetail, DiscountGoods discountGoods, Integer assess) {
        this.goodsDetail = goodsDetail;
        this.discountGoods = discountGoods;
        this.assess = assess;
    }

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Integer getAssess() {
        return assess;
    }

    public void setAssess(Integer assess) {
        this.assess = assess;
    }

    public DiscountGoods getDiscountGoods() {
        return discountGoods;
    }

    public void setDiscountGoods(DiscountGoods discountGoods) {
        this.discountGoods = discountGoods;
    }

    @Override
    public String toString() {
        return "GoodsAssessAndDetail{" +
                "goodsDetail=" + goodsDetail +
                ", discountGoods=" + discountGoods +
                ", assess=" + assess +
                '}';
    }
}

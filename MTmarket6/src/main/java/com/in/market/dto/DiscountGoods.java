package com.in.market.dto;

import com.in.market.commons.enums.DiscountEnum;
import com.in.market.commons.enums.GoodsStateEnum;
import com.in.market.commons.strategy.StrategyFactory;
import com.in.market.pojo.goods.Goods;

import java.io.Serializable;

public class DiscountGoods implements Serializable {


    private static final long serialVersionUID = 7579359685106229297L;
    private Double newPrice = 0.0;

    private Goods goods;

    public DiscountGoods() {
    }

    public DiscountGoods(Goods goods) {
        this.goods = goods;
//        newPrice = goods.getGoodsPrice();
//        if(goods.getGoodsState().equals(GoodsStateEnum.Discount.getState())) {
//            newPrice = (Double) StrategyFactory.getResult(DiscountEnum.DefaultDiscount.getDiscountName(),goods.getGoodsPrice());
//        }
        Double result = (Double) StrategyFactory.getResult(DiscountEnum.DefaultDiscount.getDiscountName(), goods.getGoodsPrice());
        newPrice = result == null ? null : result;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "DiscountGoods{" +
                "discountPrice=" + newPrice +
                ", goods=" + goods +
                '}';
    }
}

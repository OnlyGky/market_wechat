package com.in.market.dto;

import com.in.market.commons.enums.CreditEnum;
import com.in.market.commons.strategy.StrategyFactory;
import com.in.market.pojo.goods.Goods;

import java.io.Serializable;

public class IntegralGoods implements Serializable {


    private static final long serialVersionUID = -4840647014678893739L;
    private Goods goods = null;
    private Double credit;
    public IntegralGoods() {
    }

    public IntegralGoods(Goods goods) {
        this.goods = goods;
        this.credit = (Double) StrategyFactory.getResult(CreditEnum.DefaultCredit.getDiscountName(), goods.getGoodsPrice());
    }

    public IntegralGoods(Goods goods, String strategyName) {
        this.goods = goods;
        this.credit = (Double) StrategyFactory.getResult(strategyName, goods.getGoodsPrice());
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "IntegralGoods{" +
                "goods=" + goods +
                ", integral=" + credit +
                '}';
    }
}

package com.in.market.dto;

import com.in.market.commons.enums.DiscountEnum;
import com.in.market.commons.strategy.Strategy;
import com.in.market.commons.strategy.StrategyFactory;

import java.util.List;

/**
 * @author TheSevenSky
 * @param <T>  t
 */
public class PageAndList<T> {


    private Integer num;

    private Integer type;

    private Double strategy;

    private List<T> list;

    public PageAndList(Integer num, Integer type, List<T> list) {
        this.num = num;
        this.type = type;
        this.list = list;
        this.strategy = (Double) StrategyFactory.getStrategy(DiscountEnum.DefaultDiscount.getDiscountName());
    }

    public PageAndList(Integer num, Integer type, List<T> list, String strategyName) {
        this.num = num;
        this.type = type;
        this.list = list;
        this.strategy = (Double)StrategyFactory.getStrategy(strategyName);
    }

    public Double getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategyName) {
        this.strategy = (Double) StrategyFactory.getStrategy(strategyName);
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

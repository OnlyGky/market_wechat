package com.in.market.commons.strategy.impl;

import com.in.market.commons.strategy.Strategy;

/**
 * 默认的积分策略类
 * @author TheSevenSky
 */
public class DefaultIntegralStrategy implements Strategy<Double> {

    /**
     * 积分倍率
     */
    private final static double MULTIPLYING = 80;

    @Override
    public Double getResult(Double aDouble) {
        return aDouble * MULTIPLYING;
    }

    @Override
    public Double getStrategy() {
        return MULTIPLYING;
    }
}

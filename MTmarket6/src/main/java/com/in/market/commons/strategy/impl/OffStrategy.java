package com.in.market.commons.strategy.impl;

import com.in.market.commons.strategy.Strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author TheSevenSky
 */
public class OffStrategy implements Strategy<Double> {
    private static final BigDecimal STRATEGY_PRICE = new BigDecimal("0.95");

    @Override
    public Double getResult(Double aDouble) {

        return STRATEGY_PRICE.multiply(new BigDecimal(Double.toString(aDouble)))
                .setScale(2,RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public Double getStrategy() {
        //保留两位小数
        BigDecimal bigDecimal = STRATEGY_PRICE.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}

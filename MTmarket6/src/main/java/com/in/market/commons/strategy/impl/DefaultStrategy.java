package com.in.market.commons.strategy.impl;

import com.in.market.commons.strategy.Strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author TheSevenSky
 */
public class DefaultStrategy implements Strategy<Double> {
    @Override
    public Double getResult(Double aDouble) {

        return new BigDecimal(Double.toString(aDouble)).setScale(2,RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public Double getStrategy() {
        return 1.0;
    }
}

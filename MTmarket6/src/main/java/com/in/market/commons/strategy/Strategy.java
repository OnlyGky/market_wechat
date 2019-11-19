package com.in.market.commons.strategy;

/**
 * @author TheSevenSky
 * @param <T>
 */
public interface Strategy<T> {
    T getResult(T t);

    T getStrategy();
}

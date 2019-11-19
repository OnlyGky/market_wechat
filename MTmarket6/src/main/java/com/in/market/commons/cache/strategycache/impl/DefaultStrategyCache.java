package com.in.market.commons.cache.strategycache.impl;

import com.in.market.commons.cache.strategycache.StrategyCache;
import com.in.market.commons.strategy.Strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultStrategyCache implements StrategyCache<String, Strategy<Double>> {
    private static class DefaultStrategyCacheHolder{
        private static final Map<String, Strategy<Double>> CACHE = new ConcurrentHashMap<>();
    }

    @Override
    public void put(String key, Strategy<Double> doubleStrategy) {
        DefaultStrategyCacheHolder.CACHE.put(key, doubleStrategy);
    }

    @Override
    public Strategy<Double> get(String key) {
        return DefaultStrategyCacheHolder.CACHE.get(key);
    }

    @Override
    public void remove(String key) {
        DefaultStrategyCacheHolder.CACHE.remove(key);
    }

    @Override
    public boolean containsKey(String key) {
        return DefaultStrategyCacheHolder.CACHE.containsKey(key);
    }

    @Override
    public void clear() {
        DefaultStrategyCacheHolder.CACHE.clear();
    }
}

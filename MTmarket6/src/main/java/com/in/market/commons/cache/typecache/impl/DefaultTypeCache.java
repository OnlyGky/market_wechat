package com.in.market.commons.cache.typecache.impl;

import com.in.market.commons.cache.typecache.TypeCache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TheSevenSky
 */
public class DefaultTypeCache implements TypeCache<String, List> {
    private static class DefaultTypeCacheHolder{
        private static final Map<String, List<?>> CACHE = new ConcurrentHashMap<>();
    }

    @Override
    public void put(String key, List collection) {
        DefaultTypeCacheHolder.CACHE.put(key, collection);
    }

    @Override
    public List get(String key) {
        return DefaultTypeCacheHolder.CACHE.get(key);
    }



    @Override
    public void remove(String key) {
        DefaultTypeCacheHolder.CACHE.remove(key);
    }

    @Override
    public boolean containsKey(String key) {
        return DefaultTypeCacheHolder.CACHE.containsKey(key);
    }

    @Override
    public void clear() {
        DefaultTypeCacheHolder.CACHE.clear();
    }
}

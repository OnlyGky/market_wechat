package com.in.market.commons.cache;

import java.util.List;

public interface CacheInterface<K,T> {
    void put(K key, T t);

    T get(K key);

    void remove(K key);

    boolean containsKey(K key);

    void clear();
}

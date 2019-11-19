package com.in.market.dto;

import com.in.market.pojo.goods.Goods;

import java.io.Serializable;

public interface ReplacePageAndList<K, V> {

    public PageAndList<K> getOldPageAndList();


    public PageAndList<V> getNewPageAndList();
}

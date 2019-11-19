package com.in.market.dto;


import com.in.market.pojo.goods.Goods;

import java.util.ArrayList;
import java.util.List;

public class IntegralGoodsPageAndList implements ReplacePageAndList<Goods, IntegralGoods> {

    private final PageAndList<Goods> oldPageAndList;
    private final PageAndList<IntegralGoods> newPageAndList;

    public IntegralGoodsPageAndList(PageAndList<Goods> pageAndList) {
        oldPageAndList = pageAndList;
        List<IntegralGoods> list = new ArrayList<>();
        for(Goods goods : pageAndList.getList()) {
            list.add(new IntegralGoods(goods));
        }
        newPageAndList = new PageAndList<>(pageAndList.getNum(), pageAndList.getType(), list);
    }

    public IntegralGoodsPageAndList(PageAndList<Goods> pageAndList , String strategyName) {
        oldPageAndList = pageAndList;
        List<IntegralGoods> list = new ArrayList<>();
        for(Goods goods : pageAndList.getList()) {
            list.add(new IntegralGoods(goods,strategyName));
        }
        newPageAndList = new PageAndList<>(pageAndList.getNum(), pageAndList.getType(), list);
    }

    @Override
    public PageAndList<Goods> getOldPageAndList() {
        return oldPageAndList;
    }

    @Override
    public PageAndList<IntegralGoods> getNewPageAndList() {
        return newPageAndList;
    }
}

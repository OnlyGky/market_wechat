package com.in.market.dto;

import com.in.market.pojo.goods.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TheSevenSky
 *
 */
public class DiscountPageAndList implements ReplacePageAndList<Goods, DiscountGoods> {

    private final PageAndList<Goods> pageAndList;
    private final PageAndList<DiscountGoods> discountGoodsPageAndList;


    public DiscountPageAndList(PageAndList<Goods> list) {
        this.pageAndList = list;
        List<DiscountGoods> discountGoods = new ArrayList<>();
        for(Goods goods : list.getList()) {
            discountGoods.add(new DiscountGoods(goods));
        }
        discountGoodsPageAndList = new PageAndList<>(list.getNum(), list.getType(), discountGoods);

    }


    @Override
    public PageAndList<Goods> getOldPageAndList() {
        return pageAndList;
    }

    @Override
    public PageAndList<DiscountGoods> getNewPageAndList() {
        return discountGoodsPageAndList;
    }
}

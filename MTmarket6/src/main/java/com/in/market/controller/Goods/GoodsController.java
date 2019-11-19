package com.in.market.controller.goods;

import com.in.market.commons.enums.GoodsStateEnum;
import com.in.market.commons.page.DefaultPageSizeInfo;
import com.in.market.dto.*;
import com.in.market.pojo.goods.Goods;
import com.in.market.service.goods.GoodsService;
import com.in.market.service.goods.PageAndGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TheSevenSky
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService = null;

    @Autowired
    private PageAndGoodsService pageAndGoodsService = null;

    private static final Map<String, Integer> numMap = new ConcurrentHashMap<>();
    /**
     * 返回热销商品, size代表商品列表个数
     * @param num 商品的分页的页数
     * @return 商品列表
     */
    @GetMapping("/hot/{num}/goods")
    public PageAndList<DiscountGoods> getGoodsByHot(@PathVariable("num") Integer num) {
        if(num > 1) return null;
               PageNumAndList<Goods> goods = pageAndGoodsService.queryAllOrderByVolume(num, DefaultPageSizeInfo.getDefaultHotPageSize());
        return new DiscountPageAndList(new PageAndList<>(num,0,goods.getList()))
                .getNewPageAndList();
    }

    private static final String STATE_NUM_CACHE = "numByState_";
    /**
     * 同上 带个页数
     * @param state 商品状态
     * @param num 按照商品状态 返回商品清单
     * @return 按照商品状态 返回商品清单
     */
    @GetMapping("/state/{state}/{num}/goods")
    public PageAndList<DiscountGoods> getGoodsByState(@PathVariable("state") Integer state, @PathVariable("num") Integer num) {
        String key = STATE_NUM_CACHE + state;
        //if(numMap.containsKey(key) && numMap.get(key) < num) return null;
        PageNumAndList<Goods> goods = pageAndGoodsService.queryAllForState(state, num, DefaultPageSizeInfo.getPageSize());
        if(!numMap.containsKey(key) || num > numMap.get(key)) numMap.put(key, goods.getNum());
        return new DiscountPageAndList(new PageAndList<>(1, 0, goods.getList()))
                .getNewPageAndList();
    }

    private static final String DISCOUNT_NUM_CACHE = "numByDiscount";
    /**
     * 分页返回打折清单的商品
     * @param num 页数
     * @return 返回打折商品的清单
     */
    @GetMapping("/discount/{num}/goods")
    public PageAndList<DiscountGoods> getGoodsByDiscount( @PathVariable("num") Integer num) {
        if(numMap.containsKey(DISCOUNT_NUM_CACHE) && numMap.get(DISCOUNT_NUM_CACHE) < num) return null;
        PageNumAndList<Goods> goods = pageAndGoodsService.queryAllForState(GoodsStateEnum.
                Discount.getState(),num,DefaultPageSizeInfo.getPageSize());
        if(!numMap.containsKey(DISCOUNT_NUM_CACHE) || num > numMap.get(DISCOUNT_NUM_CACHE)) numMap.put(DISCOUNT_NUM_CACHE, goods.getNum());
        return new DiscountPageAndList(new PageAndList<>(1, 0, goods.getList()))
                .getNewPageAndList();
    }

    /**
     * @param typeId 类型的id
     * @param num 数量
     * @return
     */

    private static final String TYPE_NUM_CACHE = "numByTypeId_";

    @GetMapping("/id_{typeId}/{num}/goods")
    public PageAndList<DiscountGoods> getPrefixGoods(@PathVariable("typeId") Integer typeId, @PathVariable("num") Integer num) {
        String key = TYPE_NUM_CACHE + typeId;
        if (numMap.containsKey(key) && numMap.get(key) < num) return null;
        PageNumAndList<Goods> goods = pageAndGoodsService.queryAllForType(typeId, num, DefaultPageSizeInfo.getPageSize());
        if(!numMap.containsKey(key) || num > numMap.get(key)) numMap.put(key, goods.getNum());
        return new DiscountPageAndList(new PageAndList<Goods>(num, typeId, goods.getList()))
                .getNewPageAndList();
    }

    @GetMapping("/num/clear")
    public String clear() {
        numMap.clear();
        return "The Page and Num Cache Clear";
    }

    private static final String CREDIT_NUM_CACHE = "numByCredit_";

    @GetMapping("/credit/id_{typeId}/{num}/goods")
    public PageAndList<IntegralGoods> getCreditGoods(@PathVariable("typeId") Integer typeId, @PathVariable("num") Integer num) {
        String key = CREDIT_NUM_CACHE + typeId;
        if(numMap.containsKey(key) && numMap.get(key) < num) return null;
        PageNumAndList<Goods> goods = pageAndGoodsService.queryAllForType(typeId, num, DefaultPageSizeInfo.getPageSize());
        if(!numMap.containsKey(key) || num > numMap.get(key)) numMap.put(key, goods.getNum());
        return new IntegralGoodsPageAndList(new PageAndList<>(num, typeId, goods.getList())).getNewPageAndList();
    }


}

package com.in.market.controller.goods;

import com.in.market.dto.DiscountGoods;
import com.in.market.dto.GoodsAssessAndDetail;
import com.in.market.service.goods.GoodsDetailService;
import com.in.market.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/goodsDetail")
@RestController
public class GoodsDetailController {

    @Autowired
    private GoodsDetailService goodsDetailService = null;

    @Autowired
    private GoodsService goodsService = null;

    @GetMapping("/id_{id}/detail")
    public GoodsAssessAndDetail goodsAssessAndDetail(@PathVariable("id") Integer id) {
        return new GoodsAssessAndDetail(goodsDetailService.queryById(id), new DiscountGoods(goodsService.queryById(id)),100);
    }
}

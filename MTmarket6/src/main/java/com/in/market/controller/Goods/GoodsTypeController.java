package com.in.market.controller.goods;

import com.in.market.dto.PrefixGoodsType;
import com.in.market.service.goods.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TheSevenSky
 */
@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService = null;

    @GetMapping("/goodsTypes")
    public List<PrefixGoodsType> queryAll() {
        return goodsTypeService.queryAllForPrefix();
    }

    @GetMapping("/clear")
    public String clearCache() {
        goodsTypeService.clearCache();
        return "邻里鲜生";
    }
}

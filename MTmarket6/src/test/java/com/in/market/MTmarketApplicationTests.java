package com.in.market;


import com.github.pagehelper.PageHelper;
import com.in.market.commons.page.DefaultPageSizeInfo;
import com.in.market.commons.cache.typecache.TypeCache;
import com.in.market.service.cart.CartService;
import com.in.market.service.goods.GoodsService;
import com.in.market.service.goods.GoodsTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MTmarketApplicationTests {

    @Autowired
    CartService cartService = null;
//
//    @Autowired(required = false)
//    GoodsTypeDao goodsTypeDao = null;
//
//    @Autowired
//    UserDao UserDao = null;
//
//    @Autowired(required = false)
//    RedisTemplate redisTemplate = null;

    @Autowired
    GoodsService goodsService = null;

    @Autowired
    TypeCache typeCache = null;

    @Autowired
    GoodsTypeService goodsTypeService = null;

    @Test
    public void contextLoads() {
        System.out.println(PageHelper.startPage(DefaultPageSizeInfo.getPageNum(),DefaultPageSizeInfo.getPageSize())
        .doSelectPageInfo(() -> goodsService.queryAll()).getList().getClass());
    }

    @Test
    public void t1() {
//        Collection<Cart> carts = cartService.queryByUserId(2);
//        Collection<Goods> goods = goodsService.queryAll();
//        typeCache.put("carts", carts);
//        typeCache.put("goods", goods);
        System.out.println(typeCache.get("carts"));
        System.out.println(typeCache.get("goods"));
    }

    @Test
    public void t2() {
        //System.out.println(StrategyFactory.getResult("打三折"));
    }

}

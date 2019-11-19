package com.in.market.controller;


import com.alibaba.druid.pool.DruidDataSource;

import com.in.market.pojo.cart.Cart;
import com.in.market.pojo.goods.Goods;
import com.in.market.pojo.goods.GoodsType;
import com.in.market.service.goods.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private DataSource dataSource = null;

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private com.in.market.service.goods.GoodsService goodsService = null;

    @Autowired
    private GoodsTypeService goodsTypeService = null;

    @GetMapping("/hello")
    public String hello() throws Exception {
        com.in.market.pojo.cart.Cart cart;
        List<Goods> goodsList = goodsService.queryAll();
        for(int i = 1; i <= 3; i++) {
            Goods goods = goodsList.get(i);
            cart = new Cart();
            cart.setCartNum(i);
            cart.setCartPrice(goods.getGoodsPrice());
            cart.setCartGoods(goods);
            cart.setCartId(null);
            cart.setCartUser(2);
            redisTemplate.opsForHash().put(cart.getCartUser() + "", cart.getCartGoods().getGoodsId() + "", cart);
        }


        return "success";
    }

    @GetMapping("/t1")
    public String t1(Model model) {
        System.out.println(223);
        model.addAttribute("msg", "我爱刘亦菲");
        return "kk";
    }



    @GetMapping("/t2/{id}")
    @ResponseBody
    public GoodsType t2(@PathVariable("id") Integer id){
        return goodsTypeService.queryById(id);
    }

    @GetMapping("/data")
    @ResponseBody
    public String getDataSource() {
        System.out.println(((DruidDataSource)dataSource).getPoolingConnectionInfo());
        return "OK";
    }


}

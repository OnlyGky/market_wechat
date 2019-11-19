package com.in.market.service.cart.impl;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.in.market.dao.admins.AdminsDao;
import com.in.market.dao.cart.CartDao;
import com.in.market.dao.goods.GoodsDao;
import com.in.market.dto.DiscountGoods;
import com.in.market.dto.UserAndGoods;
import com.in.market.pojo.admins.Admins;
import com.in.market.pojo.cart.Cart;
import com.in.market.pojo.order.Order;
import com.in.market.service.admins.AdminsService;
import com.in.market.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author bosaidong2333
 * */
//@Service
@Transactional
public class CartServiceImpl implements CartService {

//    private static final ObjectMapper MAPPER =



    @Autowired
    private CartDao cartDao = null;

    @Autowired
    private GoodsDao goodsDao = null;

    @Autowired
    private AdminsDao adminsDao;


  //  private static final String table = "carts";


    public static final ObjectMapper MAPPER = new ObjectMapper();


    /**
     * 通过userId查询购物车集合
     *
     * @param cartUser 用户的userId
     * @return 购物车的集合
     * */
    @Override
    public List<Cart> queryByUserId(Integer cartUser) {
        return cartDao.queryByUserId(cartUser);
    }

    /**
     * 将商品保存到购物车
     *
     * @param jsonData cart的json数据，具体数据内容API文档
     *
     * */
    @Override
    public void saveGoodsToCart(String jsonData) throws Exception{

        Cart cart = MAPPER.readValue(jsonData,Cart.class);
        //  cart.setCartPrice(cart.getCartGoods().getGoodsPrice() * cart.getCartNum());
        //如果这件商品，购物车里面已经有了
        Integer userId  = cart.getCartUser();
        //String s = "123";
        if (userId == null || cart.getCartGoods() == null){
           throw new Exception();
        }

        //通过userId查找商品。如果有的话，就直接更新数量+1
        Integer goodsId = cart.getCartGoods().getGoodsId();
        if (goodsId == null){
            String str = "这里暂时不用";
            throw  new Exception();
        }

        //TODO
        //跟据userId和goodsId查找购物车。。
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("userId",userId);
        map.put("goodsId",goodsId);
        List<Cart> carts = cartDao.queryByUserIdAndGoodsId(map);


        // List<Cart> carts = cartDao.queryByUserId(userId);
        if (null != carts && carts.size()>1){
            throw new Exception("一个购物车不能放两件一模一样的东西...");
        }
        //购物车里面已经有这件东西了
        if (null != carts && carts.size() == 1){
            if (carts.get(0).getCartId()!=null && cart.getCartNum()!=null && carts.get(0).getCartNum()!=null)
                this.updateGoodsNumForCart(carts.get(0).getCartId(),cart.getCartNum() + carts.get(0).getCartNum());
            return;
        }
        //购物车里面还没有这件东西
        if (carts == null || carts.size() == 0){
            this.cartDao.saveGoodsToCart(cart);
        }
    }

    /**
     * 通过购物车Id查询某条购物车
     *
     * @param cartId 购物车Id
     * @return 查询到的购物车 / null
     * */
    private Cart queryCartByCartId(Integer cartId){
       Cart cart = this.cartDao.queryCartByCartId(cartId);
       return cart;
    }


    /**
     *更新购物车某件商品的数量
     * @param cartId 购物Id
     * @param cartNum 待修改的商品的数量
     *
     * */
    @Override
    public void updateGoodsNumForCart(Integer cartId, Integer cartNum) {
        Cart cart = this.cartDao.queryCartByCartId(cartId);

        cart.setCartNum(cartNum);
        if(cart.getCartGoods() == null || cart.getCartUser() == null){
            return;
        }


        //查询这个用户是不是会员
        Admins admins = adminsDao.selectByPrimaryKey(cart.getCartUser());
        Double result = 0.0;
        if (admins == null){
            result =   cart.getCartGoods().getGoodsPrice() * cart.getCartNum();
        }else {
          result = new DiscountGoods(cart.getCartGoods()).getNewPrice() * cart.getCartNum();
        }


        Double price = new BigDecimal(Double.toString(result)).setScale(2,RoundingMode.HALF_UP).doubleValue();
        System.out.println("计算出来的price="+result + "  --> "+"精确后价格:" + price);

        cart.setCartPrice(price);

        this.cartDao.updateCart(cart);
    }

    /**
     * 将某件商品移出购物车（从购物车中删除）
     * @param cartId 购物车Id
     *
     * */
    @Override
    public void deleteGoodsFromCart(Integer cartId) {
        this.cartDao.deleteGoodsFromCart(cartId);
    }

    /**
     * 根据userIds删除购物车
     * */
    public void deleteCartsByUserId(Integer userId){
        this.cartDao.deleteCartsByUserId(userId);
    }


    @Override
    public void updateForRedisCart(Cart cart, boolean isInsert) {

    }

    @Override
    public Map<Object, Object> queryByUserIdForMap(Integer cartUser) {
        return null;
    }

    @Override
    public void deleteGoodsForRedisCart(Integer userId, Integer goodsId) {

    }

    @Override
    public void deleteGoodsForRedisByUserIdCart(Integer userId) {

    }

    @Override
    public void updateRedisCart(UserAndGoods userAndGoods) {

    }

    @Override
    public void deleteGoodsForOrderRedisCart(Order order) {

    }
}

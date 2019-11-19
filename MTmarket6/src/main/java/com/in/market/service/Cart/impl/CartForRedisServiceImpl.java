package com.in.market.service.Cart.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in.market.dao.admins.AdminsDao;
import com.in.market.dao.cart.CartDao;
import com.in.market.dto.DiscountGoods;
import com.in.market.dto.UserAndGoods;
import com.in.market.pojo.admins.Admins;
import com.in.market.pojo.cart.Cart;
import com.in.market.pojo.order.Order;
import com.in.market.service.cart.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.in.market.pojo.order.OrderDetail;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("cartForRedisServiceImpl")
public class CartForRedisServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao = null;

    @Autowired
    private AdminsDao adminsDao;

    @Autowired
    private ObjectMapper MAPPER;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Override
    public List<Cart> queryByUserId(Integer cartUser) {
        return null;
    }

    @Override
    public void saveGoodsToCart(String jsonData) throws Exception {
        Cart cart = MAPPER.readValue(jsonData,Cart.class);
        Integer userId  = cart.getCartUser();
        if (userId == null || cart.getCartGoods() == null){
            throw new Exception();
        }
        boolean isInsert = true;
        //通过userId查找商品。如果有的话，就直接更新数量+1
        Integer goodsId = cart.getCartGoods().getGoodsId();
        if (goodsId == null){
            throw  new Exception();
        }
        Cart o = (Cart)redisTemplate.opsForHash().get(userId + "", goodsId + "");
        if (o != null) {
            if (o.getCartId()!=null && cart.getCartNum()!=null && o.getCartNum()!=null)
                o.setCartNum(o.getCartNum() + cart.getCartNum());
            isInsert = false;

        }
        updateForRedisCart(o == null?cart:o,isInsert);
    }

    @Override
    public void updateForRedisCart(Cart cart,boolean isInsert) {
        if(!isInsert) {
            pretreatment(cart);
        }
        redisTemplate.opsForHash().put(cart.getCartUser() + "", cart.getCartGoods() .getGoodsId()+ "", cart);
    }

    @Override
    public void updateGoodsNumForCart(Integer cartId, Integer cartNum) {

    }

    private void pretreatment(Cart cart) {
        Admins admins = adminsDao.selectByPrimaryKey(cart.getCartUser());
        Double result = 0.0;
        if (admins == null){
            String str = "这里暂时不用";
            result =   cart.getCartGoods().getGoodsPrice() * cart.getCartNum();
        }else {
            result = new DiscountGoods(cart.getCartGoods()).getNewPrice() * cart.getCartNum();
        }

        Double price = new BigDecimal(Double.toString(result)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        logger.info("计算出来的price="+result + "  --> "+"精确后价格:" + price);
        cart.setCartPrice(price);
    }

    @Override
    public void updateRedisCart(UserAndGoods userAndGoods) {
        Cart cart = (Cart) redisTemplate.opsForHash().get(userAndGoods.getUserId() + "", userAndGoods.getGoodsId() + "");
        cart.setCartNum(cart.getCartNum() + userAndGoods.getNum());
        pretreatment(cart);
        redisTemplate.opsForHash().put(userAndGoods.getUserId() + "", userAndGoods.getGoodsId() + "", cart);
    }

    @Override
    public void deleteGoodsFromCart(Integer cartId) {

    }

    @Override
    public Map<Object, Object> queryByUserIdForMap(Integer cartUser) {
        if(cartUser == null) throw new IllegalArgumentException("用户的id不能为空");
        return redisTemplate.opsForHash().entries(cartUser + "");
    }

    @Override
    public void deleteGoodsForRedisCart(Integer userId, Integer goodsId) {
        if(userId == null || goodsId == null) throw new IllegalArgumentException("用户id 或者 商品id为空");
        logger.info("用户 ---> " + userId + " 删除商品编号 --> " + goodsId );
        redisTemplate.opsForHash().delete(userId + "", goodsId + "");
    }

    @Override
    public void deleteGoodsForRedisByUserIdCart(Integer userId) {
        if(userId == null) throw new IllegalArgumentException("用户id为空");
        redisTemplate.opsForHash().delete(userId + "");
    }

    @Override
    @Async
    public void deleteGoodsForOrderRedisCart(Order order) {
        List<String> list = new ArrayList<>();
        for(OrderDetail orderDetail : order.getOrderDetails()) {
            list.add(orderDetail.getGoods().getGoodsId() + "");
        }
        logger.info("删除购物车 ---> 订单详情 ---> " + order);
        redisTemplate.opsForHash().delete(order.getOrderUser() + "", list.toArray());
    }
}

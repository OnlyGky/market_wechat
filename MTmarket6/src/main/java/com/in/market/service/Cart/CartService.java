package com.in.market.service.cart;




import com.in.market.dto.UserAndGoods;
import com.in.market.pojo.cart.Cart;

import java.util.List;
import java.util.Map;
import com.in.market.pojo.order.Order;

public interface CartService {

    public List<Cart> queryByUserId(Integer cartUser);

    public void saveGoodsToCart(String jsonData) throws Exception;

    void updateGoodsNumForCart(Integer cartId, Integer cartNum);

    void updateForRedisCart(Cart cart,boolean isInsert);

    void updateRedisCart(UserAndGoods userAndGoods);

    void deleteGoodsFromCart(Integer cartId);

    public Map<Object, Object> queryByUserIdForMap(Integer cartUser);

    public void deleteGoodsForRedisCart(Integer userId, Integer goodsId);

    public void deleteGoodsForRedisByUserIdCart(Integer userId);

    public void deleteGoodsForOrderRedisCart(Order order);
}

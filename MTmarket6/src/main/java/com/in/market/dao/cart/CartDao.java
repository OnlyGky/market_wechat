package com.in.market.dao.cart;




import com.in.market.pojo.cart.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartDao {
    public List<Cart> queryByUserId(Integer cartUser);

    public void saveGoodsToCart(Cart cart);

    Cart queryCartByCartId(Integer cartId);

    void updateCart(Cart cart);

    void deleteGoodsFromCart(Integer cartId);

    List<Cart> queryByUserIdAndGoodsId(Map<String,Integer> map);

    void deleteCartsByUserId(Integer userId);
}

package com.in.market.pojo.cart;



import com.in.market.pojo.goods.Goods;

import java.io.Serializable;

public class Cart implements Serializable {

    private static final long serialVersionUID = -5306232627043671025L;
    private Integer cartId;
    private Goods cartGoods;
    private Integer cartNum;
    /**
     * 可以使积分/也可以是价格
     * */
    private Double cartPrice;
    private Integer cartUser;
    /**
     * 一个标记：
     * 1：正常收费的物品
     * 2：积分的物品
     * */
    private Integer cartStatus;

    public Integer getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Integer cartStatus) {
        this.cartStatus = cartStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Goods getCartGoods() {
        return cartGoods;
    }

    public void setCartGoods(Goods cartGoods) {
        this.cartGoods = cartGoods;
    }

    public Integer getCartNum() {
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Integer getCartUser() {
        return cartUser;
    }

    public void setCartUser(Integer cartUser) {
        this.cartUser = cartUser;
    }
}

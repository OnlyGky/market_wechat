package com.in.market.dto;

import java.io.Serializable;

public class UserAndGoods implements Serializable {

    private static final long serialVersionUID = 3032922787148116871L;

    private Integer userId;
    private Integer goodsId;
    private Integer num;

    public UserAndGoods() {
    }

    public UserAndGoods(Integer userId, Integer goodsId, Integer num) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.num = num;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

package com.in.market.dto;

import com.in.market.commons.enums.PrefixTypeEnum;
import com.in.market.pojo.goods.GoodsType;

import java.io.Serializable;

/**
 * @author TheSevenSky
 */
public class PrefixGoodsType implements Serializable {


    private static final long serialVersionUID = 7664800327894831458L;
    private String prefixGoodsTypeId;

    private GoodsType goodsType;

    public PrefixGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
        this.prefixGoodsTypeId = PrefixTypeEnum.GOODS_TYPE_PREFIX.getPrefix() + goodsType.getGoodsTypeId();
    }

    public String getPrefixGoodsTypeId() {
        return prefixGoodsTypeId;
    }

    public void setPrefixGoodsTypeId(String prefixGoodsTypeId) {
        this.prefixGoodsTypeId = prefixGoodsTypeId;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }
}

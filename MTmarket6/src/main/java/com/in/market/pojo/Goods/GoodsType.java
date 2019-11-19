package com.in.market.pojo.goods;

import java.io.Serializable;

/**
 * @author TheSevenSky
 */
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 6009128944573077769L;
    private Integer goodsTypeId;
    private String goodsTypeName;
    private Integer goodsTypePid;
    /**
     * 等级
     */
    private Integer goodsTypeLv;
    private String goodsTypePath;
    private Integer goodsTypeState;

    public GoodsType() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public Integer getGoodsTypePid() {
        return goodsTypePid;
    }

    public void setGoodsTypePid(Integer goodsTypePid) {
        this.goodsTypePid = goodsTypePid;
    }

    public Integer getGoodsTypeLv() {
        return goodsTypeLv;
    }

    public void setGoodsTypeLv(Integer goodsTypeLv) {
        this.goodsTypeLv = goodsTypeLv;
    }

    public String getGoodsTypePath() {
        return goodsTypePath;
    }

    public void setGoodsTypePath(String goodsTypePath) {
        this.goodsTypePath = goodsTypePath;
    }

    public Integer getGoodsTypeState() {
        return goodsTypeState;
    }

    public void setGoodsTypeState(Integer goodsTypeState) {
        this.goodsTypeState = goodsTypeState;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "goodsTypeId=" + goodsTypeId +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                ", goodsTypePid=" + goodsTypePid +
                ", goodsTypeLv=" + goodsTypeLv +
                ", goodsTypePath='" + goodsTypePath + '\'' +
                ", goodsTypeState=" + goodsTypeState +
                '}';
    }
}

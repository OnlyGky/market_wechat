package com.in.market.pojo.goods;

import java.io.Serializable;

public class GoodsDetail implements Serializable {


    private static final long serialVersionUID = -2367820557155693342L;
    private Integer goodId;
    private String goodArea;
    private Integer goodContent;
    private Integer goodDate;
    private String goodKeep;
    private String goodsOtherImage;
    public GoodsDetail() {
    }

    public GoodsDetail(Integer goodId, String goodArea, Integer goodContent, Integer goodDate, String goodKeep, String goodsOtherImage) {
        this.goodId = goodId;
        this.goodArea = goodArea;
        this.goodContent = goodContent;
        this.goodDate = goodDate;
        this.goodKeep = goodKeep;
        this.goodsOtherImage = goodsOtherImage;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodArea() {
        return goodArea;
    }

    public void setGoodArea(String goodArea) {
        this.goodArea = goodArea;
    }

    public Integer getGoodContent() {
        return goodContent;
    }

    public void setGoodContent(Integer goodContent) {
        this.goodContent = goodContent;
    }

    public Integer getGoodDate() {
        return goodDate;
    }

    public void setGoodDate(Integer goodDate) {
        this.goodDate = goodDate;
    }

    public String getGoodKeep() {
        return goodKeep;
    }

    public void setGoodKeep(String goodKeep) {
        this.goodKeep = goodKeep;
    }

    public String getGoodsOtherImage() {
        return goodsOtherImage;
    }

    public void setGoodsOtherImage(String goodsOtherImage) {
        this.goodsOtherImage = goodsOtherImage;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "goodId=" + goodId +
                ", goodArea='" + goodArea + '\'' +
                ", goodContent=" + goodContent +
                ", goodDate=" + goodDate +
                ", goodKeep='" + goodKeep + '\'' +
                ", goodsOtherImage='" + goodsOtherImage + '\'' +
                '}';
    }
}

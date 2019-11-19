package com.in.market.pojo.order;



import com.in.market.pojo.goods.Goods;

import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailId;

    private String detailOrder;

    private Integer detailGoods;

    private Double detailPrice;

    private Integer detailNum;

//    private Integer status;

    @Transient
    private Goods goods;


    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getDetailOrder() {
        return detailOrder;
    }

    public void setDetailOrder(String detailOrder) {
        this.detailOrder = detailOrder;
    }

    public Integer getDetailGoods() {
        return detailGoods;
    }

    public void setDetailGoods(Integer detailGoods) {
        this.detailGoods = detailGoods;
    }

    public Double getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(Double detailPrice) {
        this.detailPrice = detailPrice;
    }

    public Integer getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(Integer detailNum) {
        this.detailNum = detailNum;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
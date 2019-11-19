package com.in.market.commons.enums;

/**
 * @author TheSevenSky
 */
public enum DiscountEnum {
    /**
     * 打折的枚举
     */
    DefaultDiscount("默认优惠");
    private String discountName;

    DiscountEnum(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }
}

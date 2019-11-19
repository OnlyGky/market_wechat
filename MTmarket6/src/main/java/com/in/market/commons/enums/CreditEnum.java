package com.in.market.commons.enums;

/**
 * @author TheSevenSky
 */
public enum CreditEnum {
    /**
     * 积分的枚举
     */
    DefaultCredit("默认积分优惠");
    private String creditName;

    CreditEnum(String creditName) {
        this.creditName = creditName;
    }

    public String getDiscountName() {
        return creditName;
    }

    public void setDiscountName(String discountName) {
        this.creditName = discountName;
    }
}

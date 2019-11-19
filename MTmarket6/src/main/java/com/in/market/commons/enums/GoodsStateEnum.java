package com.in.market.commons.enums;

/**
 * @author TheSevenSky
 */
public enum GoodsStateEnum {
    /**
     * 2是打折
     */
    Discount(2);

    private Integer state;

    GoodsStateEnum(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

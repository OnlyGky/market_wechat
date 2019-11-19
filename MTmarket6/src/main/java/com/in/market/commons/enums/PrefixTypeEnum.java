package com.in.market.commons.enums;

/**
 * @author TheSevenSky
 */
public enum PrefixTypeEnum {
    /**
     * GoodsType的id前缀
     */
    GOODS_TYPE_PREFIX("id_");

    private String prefix;

    PrefixTypeEnum(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

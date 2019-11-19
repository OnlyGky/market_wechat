package com.in.market.pojo.commuity;

import java.io.Serializable;

public class Commuity implements Serializable {
    private Integer cId;
    private String cName;
    private String cAbbr;

    public Commuity(Integer cId, String cName, String cAbbr) {
        this.cId = cId;
        this.cName = cName;
        this.cAbbr = cAbbr;
    }
    public Commuity() {
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAbbr() {
        return cAbbr;
    }

    public void setcAbbr(String cAbbr) {
        this.cAbbr = cAbbr;
    }
}

package com.in.market.pojo.evaimg;

import java.io.Serializable;

public class Evaimg implements Serializable {
    private static final long serialVersionUID=1L;
    private Integer evaimgId;

    private String evaimgName;

    private Integer eva;

    public Integer getEvaimgId() {
        return evaimgId;
    }

    public void setEvaimgId(Integer evaimgId) {
        this.evaimgId = evaimgId;
    }

    public String getEvaimgName() {
        return evaimgName;
    }

    public void setEvaimgName(String evaimgName) {
        this.evaimgName = evaimgName == null ? null : evaimgName.trim();
    }

    public Integer getEva() {
        return eva;
    }

    public void setEva(Integer eva) {
        this.eva = eva;
    }

    @Override
    public String toString() {
        return "Evaimg{" +
                "evaimgId=" + evaimgId +
                ", evaimgName='" + evaimgName + '\'' +
                ", eva=" + eva +
                '}';
    }
}
package com.in.market.dto;

import java.io.Serializable;
import java.util.List;

public class PageNumAndList<T> implements Serializable {

    private Integer num;
    private List<T> list;

    public PageNumAndList() {
    }

    public PageNumAndList(Integer num, List<T> list) {
        this.num = num;
        this.list = list;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageNumAndList{" +
                "num=" + num +
                ", list=" + list +
                '}';
    }
}

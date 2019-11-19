package com.in.market.util;

import java.util.List;

public class ResultList{

    private Integer total;
    private List<?> rows;


    public ResultList(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public ResultList(Long total, List<?> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }

    public ResultList() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

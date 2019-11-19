package com.in.market.pojo.integral;

import java.util.List;

/**
 *
 * 积分
 * */
public class Integral {

    //当前总积分
    private Long integralTotal;
    //用户id
    private Integer integralUser;
    //积分详情
    private List<IntegralDetail> integralDetails;

    public Long getIntegralTotal() {
        return integralTotal;
    }

    public void setIntegralTotal(Long integralTotal) {
        this.integralTotal = integralTotal;
    }

    public Integer getIntegralUser() {
        return integralUser;
    }

    public void setIntegralUser(Integer integralUser) {
        this.integralUser = integralUser;
    }
}

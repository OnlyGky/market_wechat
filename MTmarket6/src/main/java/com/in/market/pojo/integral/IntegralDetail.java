package com.in.market.pojo.integral;

import java.util.Date;

/**
 *
 * 积分明细
 * */
public class IntegralDetail {

    //积分明细id
    private String integralDetailId;
    // 用户id
    private Integer integralUser;
    // 积分明细增量
    private Integer integralDetailChange;
    //积分明细描述（如何获得此积分）
    private String integralDetailDesc;
    //获得、消费积分的日期
    private Date integralDetailDate;
    //剩余积分
    private Long integralDetailRest;

    public String getIntegralDetailId() {
        return integralDetailId;
    }

    public void setIntegralDetailId(String integralDetailId) {
        this.integralDetailId = integralDetailId;
    }

    public Integer getIntegralUser() {
        return integralUser;
    }

    public void setIntegralUser(Integer integralUser) {
        this.integralUser = integralUser;
    }

    public Integer getIntegralDetailChange() {
        return integralDetailChange;
    }

    public void setIntegralDetailChange(Integer integralDetailChange) {
        this.integralDetailChange = integralDetailChange;
    }

    public String getIntegralDetailDesc() {
        return integralDetailDesc;
    }

    public void setIntegralDetailDesc(String integralDetailDesc) {
        this.integralDetailDesc = integralDetailDesc;
    }

    public Date getIntegralDetailDate() {
        return integralDetailDate;
    }

    public void setIntegralDetailDate(Date integralDetailDate) {
        this.integralDetailDate = integralDetailDate;
    }

    public Long getIntegralDetailRest() {
        return integralDetailRest;
    }

    public void setIntegralDetailRest(Long integralDetailRest) {
        this.integralDetailRest = integralDetailRest;
    }
}

package com.in.market.service.integral;


public interface IntegralService {
    /**
     * @param userId the identity of user
     * @param total the total number of integral
     * */
    void add(Integer userId, Long total);
    /**
     * @param userId the identity of user
     * */
    Long queryTotalByUserId(Integer userId);
    /**
     * @param userId
     * @param total
     * */
    public void updateIntegralByUserId(Integer userId, Long total);
}

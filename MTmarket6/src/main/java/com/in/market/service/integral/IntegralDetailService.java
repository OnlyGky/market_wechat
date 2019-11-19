package com.in.market.service.integral;


import com.in.market.util.ResultList;



public interface IntegralDetailService {

    ResultList queryIntegralDetailByUserId(Integer userId);

    void addIntegralDetail(String integralDetailJson);

    void deleteIntegralDetailsByUserId(Integer userId);
}

package com.in.market.dao.integral;


import com.in.market.pojo.integral.Integral;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IntegralDao {
    /**
     * @param userId the identity of user
     * @param total the total number of integral
     * */
    void add(Integer userId, Long total);
    /**
     * @param userId the identity of user
     * */
    Long queryTotalByUserId(Integer userId);

    void updateIntegralByUserId(Integral integral);
}

package com.in.market.dao.integral;

import com.in.market.pojo.integral.IntegralDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IntegralDetailDao {

    List<IntegralDetail> queryIntegralDetailByUserId(Integer userId);

    void addIntegralDetail(IntegralDetail integralDetail);

    void deleteIntegralDetailsByUserId(Integer userId);
}

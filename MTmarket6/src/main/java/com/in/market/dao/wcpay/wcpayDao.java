package com.in.market.dao.wcpay;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface wcpayDao {
    @Select("select user_Openid from users where user_Id=#{id}")
    String getOpenid(@Param("id") Integer id);

}

package com.in.market.dao.cities;


import com.in.market.pojo.cities.Cities;
import com.in.market.pojo.cities.CitiesExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CitiesDao {
    long countByExample(CitiesExample example);

    int deleteByExample(CitiesExample example);

    int deleteByPrimaryKey(String cityId);

    int insert(Cities record);

    int insertSelective(Cities record);

    List<Cities> selectByExample(CitiesExample example);

    Cities selectByPrimaryKey(String cityId);

    int updateByExampleSelective(@Param("record") Cities record, @Param("example") CitiesExample example);

    int updateByExample(@Param("record") Cities record, @Param("example") CitiesExample example);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);

    List<Cities> queryCitiesByProvinceId(String provinceId);


}
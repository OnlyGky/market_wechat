package com.in.market.dao.provinces;


import com.in.market.pojo.provinces.Provinces;
import com.in.market.pojo.provinces.ProvincesExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProvincesDao {
    long countByExample(ProvincesExample example);

    int deleteByExample(ProvincesExample example);

    int deleteByPrimaryKey(String provinceId);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    List<Provinces> selectByExample(ProvincesExample example);

    Provinces selectByPrimaryKey(String provinceId);

    int updateByExampleSelective(@Param("record") Provinces record, @Param("example") ProvincesExample example);

    int updateByExample(@Param("record") Provinces record, @Param("example") ProvincesExample example);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);

    List<Provinces> findAllProvince();
}
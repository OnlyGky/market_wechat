package com.in.market.dao.zipcode;


import com.in.market.pojo.zipcode.Zipcode;

import com.in.market.pojo.zipcode.ZipcodeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZipcodeDao {
    long countByExample(ZipcodeExample example);

    int deleteByExample(ZipcodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zipcode record);

    int insertSelective(Zipcode record);

    List<Zipcode> selectByExample(ZipcodeExample example);

    Zipcode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zipcode record, @Param("example") ZipcodeExample example);

    int updateByExample(@Param("record") Zipcode record, @Param("example") ZipcodeExample example);

    int updateByPrimaryKeySelective(Zipcode record);

    int updateByPrimaryKey(Zipcode record);

    Zipcode queryZipByAreaId(String areaId);
}
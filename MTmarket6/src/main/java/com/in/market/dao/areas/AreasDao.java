package com.in.market.dao.areas;


import com.in.market.pojo.areas.Areas;
import com.in.market.pojo.areas.AreasExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreasDao {
    long countByExample(AreasExample example);

    int deleteByExample(AreasExample example);

    int deleteByPrimaryKey(String areaId);

    int insert(Areas record);

    int insertSelective(Areas record);

    List<Areas> selectByExample(AreasExample example);

    Areas selectByPrimaryKey(String areaId);

    int updateByExampleSelective(@Param("record") Areas record, @Param("example") AreasExample example);

    int updateByExample(@Param("record") Areas record, @Param("example") AreasExample example);

    int updateByPrimaryKeySelective(Areas record);

    int updateByPrimaryKey(Areas record);

    List<Areas> queryAreaByCityId(String cityId);
}
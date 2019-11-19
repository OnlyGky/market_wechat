package com.in.market.dao.evaimg;

import com.in.market.pojo.evaimg.Evaimg;
import com.in.market.pojo.evaimg.EvaimgExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EvaimgDao {
    long countByExample(EvaimgExample example);

    int deleteByExample(EvaimgExample example);

    int deleteByPrimaryKey(Integer evaimgId);

    int insert(Evaimg record);

    int insertSelective(Evaimg record);

    List<Evaimg> selectByExample(EvaimgExample example);

    Evaimg selectByPrimaryKey(Integer evaimgId);

    int updateByExampleSelective(@Param("record") Evaimg record, @Param("example") EvaimgExample example);

    int updateByExample(@Param("record") Evaimg record, @Param("example") EvaimgExample example);

    int updateByPrimaryKeySelective(Evaimg record);

    int updateByPrimaryKey(Evaimg record);
}
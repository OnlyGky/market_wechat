package com.in.market.dao.evaluate;

import com.in.market.pojo.evaluate.Evaluate;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface EvaluateDao {
    int evaUpload(Evaluate evaluate);

    List<Evaluate> queryByGId(Integer goodsId);

    List<Evaluate> queryAllByUId(Integer userId);

    int deleteByevaId(Integer evaId);

//    void updateEva(HashMap<Integer,Integer>hashMap);
      void updateEva(Integer evaId, Integer evaState);

    List<Evaluate> queryBylevel(Integer evaLevel);

    List<String> queryImasByeId(Integer evaId);

    HashMap<Integer,Integer> goodpanel(Integer goodId);
//    long countByExample(EvaluateExample example);
//
//    int deleteByExample(EvaluateExample example);
//
//    int deleteByPrimaryKey(Integer evaId);
//
//    int insert(Evaluate record);
//
//    int insertSelective(Evaluate record);
//
//    List<Evaluate> selectByExample(EvaluateExample example);
//
//    Evaluate selectByPrimaryKey(Integer evaId);
//
//    int updateByExampleSelective(@Param("record") Evaluate record, @Param("example") EvaluateExample example);
//
//    int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateExample example);
//
//    int updateByPrimaryKeySelective(Evaluate record);
//
//    int updateByPrimaryKey(Evaluate record);
//

}
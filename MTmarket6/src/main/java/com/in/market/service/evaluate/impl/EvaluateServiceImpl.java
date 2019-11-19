package com.in.market.service.evaluate.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.in.market.dao.evaimg.EvaimgDao;
import com.in.market.dao.evaluate.EvaluateDao;
import com.in.market.pojo.evaimg.Evaimg;
import com.in.market.pojo.evaluate.Evaluate;
import com.in.market.service.evaluate.EvaluateService;
import com.in.market.util.EvaluateUtil;
import com.in.market.util.ResultList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    private static final ObjectMapper MAPPER=new ObjectMapper();
    @Autowired
    EvaluateDao evaluateDao;
    @Autowired
    EvaimgDao evaimgDao;
    /**
     * 通过商品Id查询评论
     * @param goodsId
     * @return
     */
    public ResultList queryByGId(Integer goodsId) {
            List<Evaluate>evaluates=null;
            evaluates=evaluateDao.queryByGId(goodsId);
//            System.out.println("查询成功"+evaluates);
            if(evaluates!=null&&evaluates.size()>0){
                return new ResultList(evaluates.size(),evaluates);
            }
            return null;
    }

    /**
     * 提交评论
     *
     */

    public Integer evaUpload(String json) {
        Evaluate evaluate= new Evaluate();
        try {
            evaluate = MAPPER.readValue(json, Evaluate.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(evaluate.toString());

        evaluate.setEvaDate(EvaluateUtil.getNowDateShort());
        evaluateDao.evaUpload(evaluate);
        return evaluate.getEvaId();

//        if(evaimgs!=null&&evaimgs.size()>0){
//            for(Evaimg evaimg:evaimgs){
//                evaimg.setEva(evaluate.getEvaId());
//                evaimgMapper.insert(evaimg);
//            }
//        }
//        return evaluate.getEvaId();
    }

    /**
     * 通过用户Id去查询评论
     * @param userId
     * @return
     */
    public ResultList queryAllByUId(Integer userId) {
        List<Evaluate>evaluates=null;
        evaluates=evaluateDao.queryAllByUId(userId);
        System.out.println("查询成功"+evaluates);
        if(evaluates!=null&&evaluates.size()>0){
            return new ResultList(evaluates.size(),evaluates);
        }
        return null;
    }

    public boolean deleteByevaId(Integer evaId) {
        try{

            evaluateDao.deleteByevaId(evaId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean updateEva(String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        System.out.println(json.toString());
        String evaid=(String) jsonObject.getString("evaId");
        String evastate=(String)jsonObject.getString("evaState");
        if(StringUtils.isNotEmpty(evaid)&&StringUtils.isNotEmpty(evastate)){
            try {
                Integer evaId=Integer.valueOf(evaid);
                Integer evaState=Integer.valueOf(evastate);
                HashMap<Integer,Integer> hashMap=new HashMap<>();
                hashMap.put(evaId,evaState);
                evaluateDao.updateEva(evaId,evaState);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }


    public ResultList queryBylevel(Integer evaLevel) {
        List<Evaluate>evaluates=null;
        evaluates=evaluateDao.queryBylevel(evaLevel);
        System.out.println("查询成功"+evaluates);
        if(evaluates!=null&&evaluates.size()>0){
            return new ResultList(evaluates.size(),evaluates);
        }
        return null;
    }

    /*
     *根据订单号查询图片
     */
    public List<String> queryImasByeId(Integer evaId){
        List<String> list=null;
        list= evaluateDao.queryImasByeId(evaId);
        return list;
    }

    public double goodpanel(Integer goodId) {
        Map result=null;
        result=(Map)evaluateDao.goodpanel(goodId);
        Object key=result.get("key");
        Object value=result.get("value");
        if(key==null||value==null)
            return 0;
        Integer sum=Integer.valueOf(key.toString());
        Integer divide=Integer.valueOf(value.toString());
        if(sum!=0){
            return divide*1.0/sum;
        }
        return 0;
    }
}

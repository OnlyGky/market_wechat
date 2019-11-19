package com.in.market.service.integral.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.in.market.dao.integral.IntegralDao;
import com.in.market.dao.integral.IntegralDetailDao;
import com.in.market.pojo.integral.IntegralDetail;
import com.in.market.service.integral.IntegralDetailService;
import com.in.market.service.integral.IntegralService;
import com.in.market.util.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class IntegralDetailServiceImpl implements IntegralDetailService {

    @Autowired
    private IntegralDetailDao integralDetailDao;

    @Autowired
    private IntegralDao integralDao;

    @Autowired
    private IntegralService integralService;


    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 通过用户id查询订单明细集合
     * */
    public ResultList queryIntegralDetailByUserId(Integer userId){
        List<IntegralDetail> integralDetails = integralDetailDao.queryIntegralDetailByUserId(userId);
        ResultList resultList = new ResultList();
        resultList.setRows(integralDetails);
        resultList.setTotal(integralDetails.size());
        return resultList;
    }
    /**
     * 添加一条订单明细
     * */
    public void addIntegralDetail(String integralDetailJson){
        IntegralDetail integralDetail = null;
        try {
            integralDetail = MAPPER.readValue(integralDetailJson, IntegralDetail.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
            integralDetail.setIntegralDetailDate(new Date());
            //TODO
           // integralDetail.setIntegralDetailChange(2);
            integralDetail.setIntegralDetailId(UUID.randomUUID().toString().replace("-","").substring(0,15));

            //查询总积分
            Long total = integralDao.queryTotalByUserId(integralDetail.getIntegralUser());


            integralDetail.setIntegralDetailRest((total + integralDetail.getIntegralDetailChange()));

            this.integralDetailDao.addIntegralDetail(integralDetail);



            //更新总价
            Long userTotal = total + integralDetail.getIntegralDetailChange();

            integralService.updateIntegralByUserId(integralDetail.getIntegralUser(),userTotal);

    }
    /**
     * 通过userId删除订单明细
     * */
    public void deleteIntegralDetailsByUserId(Integer userId){
        this.integralDetailDao.deleteIntegralDetailsByUserId(userId);
    }


}

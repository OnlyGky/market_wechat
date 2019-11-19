package com.in.market.service.integral.impl;


import com.in.market.dao.integral.IntegralDao;
import com.in.market.pojo.integral.Integral;
import com.in.market.service.integral.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralDao integralDao;
    /**
     * 添加一条积分记录（创建user的时候创建积分）
     * */
    public void add(Integer userId,Long total){
        this.integralDao.add(userId,total);
    }

    /**
     * 通过userId查询当前积分总数
     * */
    public Long queryTotalByUserId(Integer userId){
        return this.integralDao.queryTotalByUserId(userId);
    }

    /**
     * 更改积分总数通过userId
     * */
    public void updateIntegralByUserId(Integer userId,Long total){
        Integral integral = new Integral();
        integral.setIntegralUser(userId);
        integral.setIntegralTotal(total);
        this.integralDao.updateIntegralByUserId(integral);
    }

}

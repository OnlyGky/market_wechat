package com.in.market.service.wcpay.impl;

import com.alibaba.fastjson.JSONObject;
import com.in.market.dao.wcpay.wcpayDao;
import com.in.market.service.wcpay.wcpayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.in.market.mapper.wcpay.wcpayMapper;

@Service
public class WcpayServiceImpl implements wcpayService {

    @Autowired
    wcpayDao wcpayMapper;


    @Override
    public String wcpay(String json) {
        String openId=null;
        if(StringUtils.isNotEmpty(json)){
            JSONObject jsonObject= JSONObject.parseObject(json);
            Integer id=Integer.valueOf(jsonObject.getString("id"));
            openId=wcpayMapper.getOpenid(id);
        }
        return openId;
    }
}

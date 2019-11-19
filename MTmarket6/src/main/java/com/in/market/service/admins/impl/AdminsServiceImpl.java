package com.in.market.service.admins.impl;

import com.alibaba.fastjson.JSONObject;
import com.in.market.dao.admins.AdminsDao;
import com.in.market.dao.user.UserDao;
import com.in.market.pojo.admins.Admins;
import com.in.market.pojo.user.User;
import com.in.market.service.admins.AdminsService;
import com.in.market.util.AdminsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.logging.Logger;

@Service
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    UserDao UserDao;
    @Autowired
    AdminsDao adminsDao;

    @Override
    public Admins save(String json) {
//        JSONObject jsonObject=JSONObject.parseObject(json);
//        Integer adminId=jsonObject.getInteger("userId");
        Integer adminId=Integer.valueOf(json.substring(6,json.length()));

        Admins admins=null;
        //首先判断该用户是否已经充值过
       admins= adminsDao.selectByPrimaryKey(adminId);
       if(admins!=null){
           //判断数据库的会员是否已经结束，如未结束，直接从数据库时间增加
           if(AdminsUtils.equalsDate(admins.getAdminDate(),AdminsUtils.getNowDateShort())){
                admins.setAdminDate(AdminsUtils.getNownextMonth());
           }else {
               try {
                   admins.setAdminDate(AdminsUtils.subMonth(admins.getAdminDate()));
               } catch (ParseException e) {
                   e.printStackTrace();
               }
           }
           admins.setAdminState(2);
           adminsDao.updateByPrimaryKey(admins);
           return admins;
       }
       User user= UserDao.selectByPrimaryKey(adminId);
        if(user!=null){

        admins=new Admins(adminId,user.getUserName(),user.getUserPhone(),AdminsUtils.getNownextMonth(),2,1);
        adminsDao.insert(admins);
        }
        return admins;
    }

    @Override
    public Admins query(String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        Integer adminId=jsonObject.getInteger("adminId");
        Admins admins=null;
        admins= adminsDao.selectByPrimaryKey(adminId);
//        System.out.println("查找成功"+admins.toString());
        if(admins!=null){
            //判断会员是否已经到期
            if(AdminsUtils.equalsDate(admins.getAdminDate(),AdminsUtils.getNowDateShort())){
                if(admins.getAdminState()==2){
                admins.setAdminState(1);
                adminsDao.updateByPrimaryKey(admins);
                }
                return admins;
            }
        }
        return admins;
    }
}

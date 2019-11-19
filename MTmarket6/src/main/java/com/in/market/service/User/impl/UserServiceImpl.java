package com.in.market.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.in.market.dao.user.UserDao;
import com.in.market.pojo.user.User;
import com.in.market.pojo.user.UserExample;
import com.in.market.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao UserDao;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //保存
    public boolean save(String jsonUser) {
        User user=null;
        user =  JSONObject.parseObject(jsonUser, User.class);
        return 0!= UserDao.insert(user);
    }
   //删除
    public boolean delete(Integer userId) {
       return UserDao.deleteByPrimaryKey(userId)!=0;
    }
  //更新
    public boolean upadte(String jsonUser) {
        User user=null;
        try {
            user=MAPPER.readValue(jsonUser,User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return UserDao.updateByPrimaryKey(user)!=0;
    }
    //查找
    public User query(Integer userId) {
       return UserDao.selectByPrimaryKey(userId);
    }

    //检查根据UserId判断用户是否存在
    public boolean check(Integer userId) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
       return UserDao.countByExample(userExample)!=0;
    }


    //修改state
    public boolean up_state(Integer userId, Integer userState) {
        return UserDao.up_state(userId,userState)!=0;
    }

    //根据openId判断用户是否存在
    public Integer queryByOpenId(String openId) {
        return UserDao.selectByOpenId(openId);
    }

    //保存一个User类
    public Integer saveUser(User user) {
        Integer userId=null;
        UserDao.saveUser(user);
        userId=user.getUserId();
        return userId;
    }

    //根据openId获取Uid
    public Integer getUId(String openId) {
        return UserDao.getUId(openId);
    }
}

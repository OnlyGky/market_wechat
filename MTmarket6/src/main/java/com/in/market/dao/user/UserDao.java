package com.in.market.dao.user;

import com.in.market.pojo.user.User;
import com.in.market.pojo.user.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //根据User_Id修改用户权限
    int up_state(@Param(value = "userId") Integer userId, @Param(value = "userState") Integer userState);

    Integer selectByOpenId(String openId);

    Integer getUId(String openId);

    void saveUser(User user) ;

    String selectPhone(Integer adminId);
}
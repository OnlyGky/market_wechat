package com.in.market.service.user;

import com.in.market.pojo.user.User;

public interface UserService {

    public boolean save(String jsonUser);

    public boolean delete(Integer userId);

    public boolean upadte(String jsonUser);

    public User query(Integer userId);

    public boolean check(Integer userId);

    public boolean up_state(Integer userId, Integer userState);

    public Integer queryByOpenId(String openId);

    public Integer saveUser(User user);

    public Integer getUId(String openId);
}

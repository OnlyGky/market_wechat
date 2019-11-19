package com.in.market.pojo.user;

public class User {
    private Integer userId;

    private String userName;

    private String userOpenid;

    private String userPhone;

    private Integer userState;

    public User() {
    }

    public User(Integer userId,String userOpenid) {
        this.userId = userId;
        this.userOpenid=userOpenid;
    }

    public User(Integer userId, String userName, String userOpenid, String userPhone, Integer userState) {
        this.userId = userId;
        this.userName = userName;
        this.userOpenid = userOpenid;
        this.userPhone = userPhone;
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userOpenid='" + userOpenid + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userState=" + userState +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}
package com.in.market.pojo.evaluate;

import com.in.market.pojo.evaimg.Evaimg;

import java.io.Serializable;
import java.util.List;

public class Evaluate implements Serializable {
    private Integer evaId;

    private Integer evaUser;

    private String evaContent;

    private String evaDate;

    private Integer evaGoods;

    private Integer evaState;

    private Integer evaLevel;

    private String userPhoto;

    private String userName;

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //    private List<Evaimg> evaimgs;
//
//    public List<Evaimg> getEvaimgs() {
//        return evaimgs;
//    }
//
//    public void setEvaimgs(List<Evaimg> evaimgs) {
//        this.evaimgs = evaimgs;
//    }

    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }

    public Integer getEvaUser() {
        return evaUser;
    }

    public void setEvaUser(Integer evaUser) {
        this.evaUser = evaUser;
    }

    public String getEvaContent() {
        return evaContent;
    }

    public void setEvaContent(String evaContent) {
        this.evaContent = evaContent == null ? null : evaContent.trim();
    }

    public String getEvaDate() {
        return evaDate;
    }

    public void setEvaDate(String evaDate) {
        this.evaDate = evaDate;
    }

    public Integer getEvaGoods() {
        return evaGoods;
    }

    public void setEvaGoods(Integer evaGoods) {
        this.evaGoods = evaGoods;
    }

    public Integer getEvaState() {
        return evaState;
    }

    public void setEvaState(Integer evaState) {
        this.evaState = evaState;
    }

    public Integer getEvaLevel() {
        return evaLevel;
    }

    public void setEvaLevel(Integer evaLevel) {
        this.evaLevel = evaLevel;
    }

    public Evaluate() {
    }

    public Evaluate(Integer evaId, Integer evaUser, String evaContent, String evaDate, Integer evaGoods, Integer evaState, Integer evaLevel, String userPhoto, String userName) {
        this.evaId = evaId;
        this.evaUser = evaUser;
        this.evaContent = evaContent;
        this.evaDate = evaDate;
        this.evaGoods = evaGoods;
        this.evaState = evaState;
        this.evaLevel = evaLevel;
        this.userPhoto = userPhoto;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaId=" + evaId +
                ", evaUser=" + evaUser +
                ", evaContent='" + evaContent + '\'' +
                ", evaDate='" + evaDate + '\'' +
                ", evaGoods=" + evaGoods +
                ", evaState=" + evaState +
                ", evaLevel=" + evaLevel +
                ", userPhoto='" + userPhoto + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
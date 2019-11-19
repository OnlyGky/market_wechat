package com.in.market.util;

import com.alibaba.fastjson.JSONObject;
import com.in.market.pojo.admins.Admins;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdminsUtils {

   public static String getNownextMonth() {
       Calendar cal = Calendar.getInstance();
       cal.add(cal.MONTH, 1);
       SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
       String preMonth = dft.format(cal.getTime());
       return preMonth;
   }

    public static String getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

//    JAVA判断两个日期的大小
    public static boolean equalsDate(String beainTime,String endTime){
       //判断开始时间是否小于结束时间
       return beainTime.compareTo(endTime)<0;
    }

    //给指定日期添加一个月
    public   static String subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

//    public static Admins getAdmins(String json) {
//        JSONObject jsonObject=JSONObject.parseObject(json);
//        try {
//            Integer adminId = jsonObject.getInteger("adminId");
//            String adminName = jsonObject.getString("adminName");
//            String adminPhone = jsonObject.getString("adminPhone");
//            String adminDate = AdminsUtils.getNownextMonth();
//            return new Admins(adminId,adminName,adminPhone,adminDate,1,1);
//        }catch(Exception e){
//            return null;
//        }
//    }
}

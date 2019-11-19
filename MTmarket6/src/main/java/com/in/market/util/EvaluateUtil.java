package com.in.market.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EvaluateUtil {


    /**
     * 从文件中删除照片
     * @param list
     */
    public static void deleteImages(List<String> list) {
        for(String img:list){

            String fileName="D:\\IDEAJAVA\\ssm__15_MTmarket\\src\\main\\webapp\\images\\"+img;
            File file=new File(fileName);
            if(file.exists()){
                System.out.println("正在删除图片"+img);
                file.delete();
            }
        }
    }

    /*
     *生成十一位的随机数字
     */
    public  String getRandom(){
        return UUID.randomUUID().toString().substring(0,7);
    }
    /**
     * 获取现在时间
     */
    public static String getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}

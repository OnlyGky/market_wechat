package com.in.market.util;

import com.alibaba.fastjson.JSONObject;
import com.in.market.pojo.user.User;
import com.in.market.pojo.wcapplogin.WcApplogin;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 调用小程序的工具类
 */
public class WcAppLoginUtil {

    //获取code取得的信息
    //小程序 appId
   static final String wcAppid="wx44c0c9124f54a4d2";
    //小程序 appSecret
   static final String wcSercet="86c52ac2d7b87dfe5987566b7441df79";
    public static WcApplogin wcLogin(JSONObject jsonObject){
    //登录时获取的code
    String wcCode=jsonObject.getString("code");

    //授权类型，此处只需填写 authorization_code
    String wcGrant_type="authorization_code";

    String url="appid="+wcAppid+"&"+"secret="+wcSercet+"&"+"js_code="+wcCode+"&"+"grant_type="+wcGrant_type;
    //向微信后台发送请求,HttpUtils为utils下的工具类
    String result= HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session",url) ;
    //解析相应的内容，换成对象
    WcApplogin wcApplogin=null;
        try{
        wcApplogin= JSONObject.parseObject(result, WcApplogin.class);
    }
        catch(Exception e){
        return null;
        }
        return wcApplogin;
    }
    //解密获取user
    public static User getUser(String openId, String nickName){
                User user=new User();
                user.setUserName(nickName);
                user.setUserOpenid(openId);
                user.setUserId(null);
                return user;
    }


//    public void getAccess_token(){
//        String url = "&appid=" + wcAppid + "&secret=" + wcSercet;
//        String grant_type="client_credential";
//        String params = "grant_type=" + grant_type + "&secret=" + wxspSecret + "&appid="+ wxspAppid;
//        //发送GET请求
//        String sendGet = HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", params)
//        JSONObject jsonObject=JSONObject.parseObject(json);
//        System.out.println(jsonObject);
//    }

    public static String getAccessToken() throws Exception{
        String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                +wcAppid+ "&secret="+wcSercet;
        System.out.println("URL for getting accessToken accessTokenUrl="+accessTokenUrl);

        URL url = new URL(accessTokenUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();

        //获取返回的字符
        InputStream inputStream = connection.getInputStream();
        int size =inputStream.available();
        byte[] bs =new byte[size];
        inputStream.read(bs);
        String message=new String(bs,"UTF-8");

        //获取access_token
        JSONObject jsonObject = JSONObject.parseObject(message);
        String accessToken = jsonObject.getString("access_token");
        String expires_in = jsonObject.getString("expires_in");
//        System.out.println("accessToken="+accessToken);
//        System.out.println("expires_in="+expires_in);
        return accessToken;
    }


}

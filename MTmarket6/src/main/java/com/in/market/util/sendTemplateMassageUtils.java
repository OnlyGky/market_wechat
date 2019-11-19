package com.in.market.util;

import com.alibaba.fastjson.JSONObject;
import com.in.market.pojo.sendTemplateMessage.TemplateData;
import com.in.market.pojo.sendTemplateMessage.sendTemplateMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class sendTemplateMassageUtils {

    //发送微信模板的url
    public static final String url="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=";


    public static JSONObject sendTemplateMessage(String touser, String formid,String dtemplate_id, Map<String, TemplateData> map) throws Exception {
        //获取token
        String accessToken = WcAppLoginUtil.getAccessToken();

        sendTemplateMessage sendTemplateMessage = new sendTemplateMessage();
        //拼接数据
        sendTemplateMessage.setTouser(touser);
        sendTemplateMessage.setTemplate_id(dtemplate_id);
        sendTemplateMessage.setPage("");
        sendTemplateMessage.setForm_id(formid);
        sendTemplateMessage.setData(map);
        sendTemplateMessage.setEmphasis_keyword("");
        String json =  JSONObject.toJSONString(sendTemplateMessage);
        System.out.println(sendTemplateMessage.toString());
        System.out.println("##模版发送JSON数据:  "+json);
        String ret = sendTemplateMassageUtils.sendPost(url+accessToken, json);
        System.out.println("发送成功");
        return JSONObject.parseObject(ret);
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常!"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

}

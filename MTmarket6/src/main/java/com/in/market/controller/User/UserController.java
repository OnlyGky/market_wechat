package com.in.market.controller.user;



import com.alibaba.fastjson.JSONObject;
import com.in.market.controller.wcpay.wcpayController;
import com.in.market.pojo.user.User;
import com.in.market.pojo.wcapplogin.WcApplogin;
import com.in.market.service.user.UserService;
import com.in.market.service.user.impl.UserServiceImpl;




import com.in.market.util.WcAppLoginUtil;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userServer;

    /**
     * 接收小程序传来的code返回用户信息
     */
//    code:loginRes.code,//临时登录凭证
//    rawData:infoRes.rawData,//用户非敏感信息
//    signature:infoRes.signature,//签名
//    encrypteData:infoRes.encryptedData,//用户敏感信息
//    iv:infoRes.iv//解密算法的向量
    @RequestMapping(value="login",method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody String json) throws Exception {

        if(StringUtils.isNotEmpty(json)){
            JSONObject jsonObject=JSONObject.parseObject(json);
            //解析获取openId和session_key
            WcApplogin wcAppLogin=WcAppLoginUtil.wcLogin(jsonObject);

            //判断获取到的openId是否为空，如果不为空则先查找数据库
            if(StringUtils.isNotEmpty(wcAppLogin.getOpenId())){
               Integer userId= userServer.queryByOpenId(wcAppLogin.getOpenId());

               if(userId!=null) {
                   LOGGER.info("二次"+userId);
                   User temp=new User(userId,wcAppLogin.getOpenId());
                   LOGGER.info("登录成功"+temp.toString());
                   return ResponseEntity.ok(temp);
                   //如果userId为空，则补全获取信息存到数据库中
               }
               else{
//                   System.out.println(AES.wxDecrypt(jsonObject.getString("encrypteData"),wcAppLogin.getSession_key(),jsonObject.getString("iv")));
                    userId=userServer.saveUser(WcAppLoginUtil.getUser(wcAppLogin.getOpenId(),(String) jsonObject.getString("nickName")));
                   LOGGER.info("首次登陆"+userId);
                   User temp=new User(userId,wcAppLogin.getOpenId());
                   LOGGER.info("登录成功"+temp.toString());
                   return ResponseEntity.ok(temp);
                   //获取解析的数据
//                   System.out.println("获取秘钥成功"+AesCbcUtils.decrypt(jsonObject.getString("encryptedData"),wcAppLogin.getSession_key(),jsonObject.getString("iv"),"UTF-8"));
//                   System.out.println(WXBizDataCrypt.getInstance().decrypt(jsonObject.getString("encrypteData"),wcAppLogin.getSession_key(),jsonObject.getString("iv"),"UTF-8"));
//                   System.out.println(jsonObject);
               }
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /*
     *注册User,跳转success页面或fail页面
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody String jsonUser) {
        if (StringUtils.isNotEmpty(jsonUser)){
            if (userServer.save(jsonUser))
                return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    /*
     *删除用户信息
     */
    @RequestMapping(value = "/delete/{userId}",method =RequestMethod.GET)
    public ResponseEntity<Void> delete(@PathVariable Integer userId){
        LOGGER.info("*****"+userId);
            if(userServer.delete(userId)){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /*
    *修改用户信息
     */
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody String jsonUser){
        if (StringUtils.isNotEmpty(jsonUser)){
            if (userServer.upadte(jsonUser))
                return "success";
            return "fail";
        }
        else
            return "fail";
    }


    /*
    *查找用户信息
     */
//    @RequestMapping(value = "query/{userId}",method = RequestMethod.GET)
    public ResponseEntity<User> query(@PathVariable Integer userId){
//        System.out.println(userId);
//        System.out.println("***********");
//        System.out.println(Integer.MAX_VALUE);
       User user =null;
       user= userServer.query(userId);
//        System.out.println("user............."+user);
       if(user!=null)
        return  ResponseEntity.ok(user);
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /*
    *判断用户是否存在
     */
    @RequestMapping("/check")
    public ResponseEntity<Void> check(@PathVariable(value = "userId")Integer userId){
       if(userServer.check(userId)){
         return ResponseEntity.status(HttpStatus.OK).build();
       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /*
     *根据user_Id修改用户权限
     */
    @RequestMapping("/up_state")
    public ResponseEntity<Void> up_state(Integer userId,Integer userState){
        if(userServer.up_state(userId,userState)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}

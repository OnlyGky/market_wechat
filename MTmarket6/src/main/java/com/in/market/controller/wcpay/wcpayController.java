//package com.in.market.controller.wcpay;
//
//import com.in.market.config.wcpayConfig;
//import com.in.market.service.admins.AdminsService;
//import com.in.market.service.order.OrderService;
//import com.in.market.service.wcpay.wcpayService;
//import com.in.market.util.WcPayUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/wcpay")
//public class wcpayController {
//
//    @Autowired
//    wcpayService wcpayService;
//
//    @Autowired
//    OrderService orderService;
//    @Autowired
//    AdminsService adminsService;
//    /**
//     * 发起微信支付
//     * @param json  用户id
//     * @param request
//     * @return
//     */
//    @RequestMapping("/pay")
//    public ResponseEntity<Map<String, Object>> wcpay (@RequestBody String json, HttpServletRequest request){
//        String openid=null;
//
//        if(StringUtils.isNotEmpty(json)){
//
//            openid=wcpayService.wcpay(json);
//        }
////        JSONObject jsonObject=JSONObject.parseObject(json);
////        WcApplogin wcAppLogin= WcAppLoginUtil.wcLogin(jsonObject);
////        openid=wcAppLogin.getOpenId();
////        System.out.println(wcAppLogin.toString());
//        System.out.println(openid);
//        try{
//            //生成的随机字符串
//            String nonce_str = WcPayUtil.getRandomStringByLength(32);
//            //商品名称
//            String body = WcPayUtil.getName(json);
////            String body ="测试商品";
//            //获取客户端的ip地址
//            String spbill_create_ip = WcPayUtil.getIpAddr(request);
//
//            //获得价钱
//            String total_fee=WcPayUtil.getPrice(json);
//            System.out.println(total_fee);
////            String total_fee="1";
//            //商户订单号
//           String out_trade_no=WcPayUtil.getOrder(json);
////            String out_trade_no="123456789";
//            //组装参数，用户生成统一下单接口的签名
//            Map<String, String> packageParams = new HashMap<String, String>();
//            packageParams.put("appid", wcpayConfig.appid);
//            packageParams.put("mch_id", wcpayConfig.mch_id);
//            packageParams.put("nonce_str", nonce_str);
//            packageParams.put("body", body);
//
//            packageParams.put("out_trade_no", out_trade_no);//商户订单号
//            packageParams.put("total_fee", total_fee);//支付金额，这边需要转成字符串类型，否则后面的签名会失败
//            packageParams.put("spbill_create_ip", spbill_create_ip);
//            packageParams.put("notify_url", wcpayConfig.notify_url);//支付成功后的回调地址
//            packageParams.put("trade_type", wcpayConfig.TRADETYPE);//支付方式
//            packageParams.put("openid",openid );
//
//            String prestr = WcPayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
//
//            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
//            String mysign = WcPayUtil.sign(prestr, wcpayConfig.key, "utf-8").toUpperCase();
//
//            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
//            String xml = "<xml>" + "<appid>" + wcpayConfig.appid + "</appid>"
//                    + "<body><![CDATA[" + body + "]]></body>"
//                    + "<mch_id>" + wcpayConfig.mch_id + "</mch_id>"
//                    + "<nonce_str>" + nonce_str + "</nonce_str>"
//                    + "<notify_url>" + wcpayConfig.notify_url + "</notify_url>"
//                    + "<openid>" + openid + "</openid>"
//                    + "<out_trade_no>" + out_trade_no + "</out_trade_no>"
//                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"
//                    + "<total_fee>" + total_fee + "</total_fee>"
//                    + "<trade_type>" + wcpayConfig.TRADETYPE + "</trade_type>"
//                    + "<sign>" + mysign + "</sign>"
//                    + "</xml>";
//
//            System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);
//
//            //调用统一下单接口，并接受返回的结果
//            String result = WcPayUtil.httpRequest(wcpayConfig.pay_url, "POST", xml);
//
//            System.out.println("调试模式_统一下单接口 返回XML数据：" + result);
//
//            // 将解析结果存储在HashMap中
//            Map map = WcPayUtil.doXMLParse(result);
//            System.out.println(map);
//            String return_code = (String) map.get("return_code");//返回状态码
//
//            Map<String, Object> response = new HashMap<String, Object>();//返回给小程序端需要的参数
//            if(return_code.equals("SUCCESS")){
//                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
//                response.put("nonceStr", nonce_str);
//                response.put("package", "prepay_id=" + prepay_id);
//                Long timeStamp = System.currentTimeMillis() / 1000;
//                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
//                //拼接签名需要的参数
//                String stringSignTemp = "appId=" + wcpayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id+ "&signType=MD5&timeStamp=" + timeStamp;
//                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
//                String paySign = WcPayUtil.sign(stringSignTemp, wcpayConfig.key, "utf-8").toUpperCase();
//
//                response.put("paySign", paySign);
//            }
//
//            response.put("appid", wcpayConfig.appid);
//
//            return ResponseEntity.ok(response);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    }
//
//
//
//    /**
//     * @Description:微信支付
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value="/wxNotify")
//    @ResponseBody
//    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception{
//        System.out.println("访问成功");
//        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
//        String line = null;
//        StringBuilder sb = new StringBuilder();
//        while((line = br.readLine()) != null){
//            sb.append(line);
//        }
//        br.close();
//        //sb为微信返回的xml
//        String notityXml = sb.toString();
//        String resXml = "";
//        System.out.println("接收到的报文：" + notityXml);
//
//        Map map = WcPayUtil.doXMLParse(notityXml);
//
//        String returnCode = (String) map.get("return_code");
//        if("SUCCESS".equals(returnCode)){
//            //验证签名是否正确
//            Map<String, String> validParams = WcPayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
//            String validStr = WcPayUtil.createLinkString(validParams);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
//            String sign = WcPayUtil.sign(validStr, wcpayConfig.key, "utf-8").toUpperCase();//拼装生成服务器端验证的签名
//            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
//            if(sign.equals(map.get("sign"))){
//                //修改订单为已支付
//                String out_trade_no=(String) map.get("out_trade_no");
////                if(out_trade_no)
//               String s=out_trade_no.substring(0,6);
//               if(s.equals("ssssss")){
//                   adminsService.save(out_trade_no);
//               }else {
//                   orderService.changeOrderStatus2(out_trade_no);
//               }
//                //通知微信服务器已经支付成功
//                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
//                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
//            }
//        }else{
//            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
//                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
//        }
//        System.out.println(resXml);
//        System.out.println("微信支付回调数据结束");
//
//
//        BufferedOutputStream out = new BufferedOutputStream(
//                response.getOutputStream());
//        out.write(resXml.getBytes());
//        out.flush();
//        out.close();
//    }
//}
package com.in.market.controller.wcpay;

import com.alibaba.fastjson.JSONObject;
import com.in.market.config.wcpayConfig;
import com.in.market.controller.afterSale.FileUploadController;
import com.in.market.pojo.admins.Admins;
import com.in.market.pojo.sendTemplateMessage.TemplateData;
import com.in.market.service.admins.AdminsService;
import com.in.market.service.order.OrderService;
import com.in.market.service.wcpay.wcpayService;
import com.in.market.util.AdminsUtils;
import com.in.market.util.WcPayUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static com.in.market.util.sendTemplateMassageUtils.sendTemplateMessage;

@Controller
@RequestMapping("/wcpay")
public class wcpayController {
    private static final Logger LOGGER = LoggerFactory.getLogger(wcpayController.class);
    @Autowired
    wcpayService wcpayService;

    @Autowired
    OrderService orderService;
    @Autowired
    AdminsService adminsService;
    @Autowired
    com.in.market.service.user.UserService userService;

    //订单模板Id
    public static final String dtemplate_id="naXfsHCVYCzPk-1bXihnPJF920MmcEkc5CazLmrC6K8";

    //会员模板id
    public static final String hdtemplate_id="YN0PoNQvcyj3SdMTGXRGMoA3FzbDAwTI-cvh0W-AGgs";
    /**
     * 发起微信支付
     * @param json  用户id
     * @param request
     * @return
     */
    @RequestMapping("/pay")
    public ResponseEntity<Map<String, Object>> wcpay (@RequestBody String json, HttpServletRequest request){

        String openid=null;

        if(StringUtils.isNotEmpty(json)){
            openid=wcpayService.wcpay(json);
        }
//        JSONObject jsonObject=JSONObject.parseObject(json);
//        WcApplogin wcAppLogin= WcAppLoginUtil.wcLogin(jsonObject);
//        openid=wcAppLogin.getOpenId();
//        System.out.println(wcAppLogin.toString());
        LOGGER.info("成功调起预支付接口"+openid);
        try{
            //生成的随机字符串
            String nonce_str = WcPayUtil.getRandomStringByLength(32);
            //商品名称
            String body = WcPayUtil.getName(json);
//            String body ="测试商品";
            //获取客户端的ip地址
            String spbill_create_ip = WcPayUtil.getIpAddr(request);

            //获得价钱
            String total_fee=WcPayUtil.getPrice(json);
//            System.out.println(total_fee);
//            String total_fee="1";
            //商户订单号
            String out_trade_no=WcPayUtil.getOrder(json);
            //如果为开通会员进行另一种处理
            String s=out_trade_no.substring(0,6);
            if(s.equals("ssssss")){
                String filename= RandomStringUtils.randomAlphanumeric(3);
                Integer adminId=Integer.valueOf(json.substring(6,out_trade_no.length()));
                out_trade_no="sss"+filename+adminId;
            }else{
                //校验验证码
                int code = WcPayUtil.getCode(json);
                if(code!=-1 && out_trade_no.hashCode()!=code){

                    Map<String, Object> errcode = new HashMap<String, Object>();//返回给小程序端需要的参数
                    errcode.put("200","errcode");
                    LOGGER.info("errcode "+out_trade_no);
                   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errcode);
                }
                out_trade_no=out_trade_no+RandomStringUtils.randomAlphanumeric(2);
            }
//            String out_trade_no="123456789";
            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<String, String>();
            packageParams.put("appid", wcpayConfig.appid);
            packageParams.put("mch_id", wcpayConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);

            packageParams.put("out_trade_no", out_trade_no);//商户订单号
            packageParams.put("total_fee", total_fee);//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);
            packageParams.put("notify_url", wcpayConfig.notify_url);//支付成功后的回调地址
            packageParams.put("trade_type", wcpayConfig.TRADETYPE);//支付方式
            packageParams.put("openid",openid );

            String prestr = WcPayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = WcPayUtil.sign(prestr, wcpayConfig.key, "utf-8").toUpperCase();

            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid>" + wcpayConfig.appid + "</appid>"
                    + "<body><![CDATA[" + body + "]]></body>"
                    + "<mch_id>" + wcpayConfig.mch_id + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + wcpayConfig.notify_url + "</notify_url>"
                    + "<openid>" + openid + "</openid>"
                    + "<out_trade_no>" + out_trade_no + "</out_trade_no>"
                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"
                    + "<total_fee>" + total_fee + "</total_fee>"
                    + "<trade_type>" + wcpayConfig.TRADETYPE + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";

            LOGGER.info("调试模式_统一下单接口 请求XML数据：" + xml);

            //调用统一下单接口，并接受返回的结果
            String result = WcPayUtil.httpRequest(wcpayConfig.pay_url, "POST", xml);

            LOGGER.info("调试模式_统一下单接口 返回XML数据：" + result);

            // 将解析结果存储在HashMap中
            Map map = WcPayUtil.doXMLParse(result);

            String return_code = (String) map.get("return_code");//返回状态码

            Map<String, Object> response = new HashMap<String, Object>();//返回给小程序端需要的参数
            if(return_code.equals("SUCCESS")){
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                response.put("nonceStr", nonce_str);
                response.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + wcpayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id+ "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = WcPayUtil.sign(stringSignTemp, wcpayConfig.key, "utf-8").toUpperCase();

                response.put("paySign", paySign);
            }

            response.put("appid", wcpayConfig.appid);

            return ResponseEntity.ok(response);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }



    /**
     * @Description:微信支付
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/wxNotify")
    @ResponseBody
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";


        Map map = WcPayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            Map<String, String> validParams = WcPayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
            String validStr = WcPayUtil.createLinkString(validParams);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String sign = WcPayUtil.sign(validStr, wcpayConfig.key, "utf-8").toUpperCase();//拼装生成服务器端验证的签名
            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            if(sign.equals(map.get("sign"))){
                //修改订单为已支付
                String out_trade_no=(String) map.get("out_trade_no");
//                System.out.println("获取到的pre"+map);
//                String preyId=(String)map.get("prepay_id");
//                if(out_trade_no)
                String s=out_trade_no.substring(0,3);
                if(s.equals("sss")){
                   Admins admins= adminsService.save(out_trade_no);
//                    com.in.market.pojo.user.User user=userService.query(admins.getAdminId());
//                    Map<String,TemplateData> map1 = new HashMap<>();
//                    map1.put("keyword1",new TemplateData( AdminsUtils.getNowDateShort()));
//                    map1.put("keyword2",new TemplateData(admins.getAdminDate()));
//                    map1.put("keyword3",new TemplateData("6.6元"));
//                    JSONObject js = sendTemplateMessage(user.getUserOpenid(), preyId,hdtemplate_id,map1);
//                    System.out.println("会员支付成功"+js);
                }else {
                    out_trade_no=out_trade_no.substring(0,out_trade_no.length()-2);
                    System.out.println("订单号为"+out_trade_no);
                    orderService.changeOrderStatus2(out_trade_no);
//                   com.in.market.pojo.order.Order order=orderService.queryByOrderId(out_trade_no);
//                   com.in.market.pojo.user.User user=userService.query(order.getOrderUser());
//                   String addrDid=order.getOrderExpressNo();
//                   String orderDate=String.valueOf(order.getOrderDate());
//                   String phone="18191244857";
//                   String state="已支付";
//                   String address="大学生活服务部南边小超市(东区天桥旁超市)";
//                   String function="微信支付";
//                    Map<String, TemplateData> map1 = new HashMap<>();
//                    map1.put("keyword1",new TemplateData(phone));
//                    map1.put("keyword2",new TemplateData(addrDid));
//                    map1.put("keyword3",new TemplateData(state));
//                    map1.put("keyword4",new TemplateData(address));
//                    map1.put("keyword5",new TemplateData(orderDate));
//                    map1.put("keyword6",new TemplateData(function));
//                    JSONObject js = sendTemplateMessage(user.getUserOpenid(), preyId,dtemplate_id,map1);
//                    System.out.println("订单支付成功"+js);
                }
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");


        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }
}

package com.in.market.config;
/**
 * 小程序微信支付的配置文件
 * @author
 *
 */
public class wcpayConfig {
        //小程序appid
        public static final String appid = "wx44c0c9124f54a4d2";
        //微信支付的商户id
        public static final String mch_id = "1534628421";
        //微信支付的商户密钥
        public static final String key = "420222199907042830lvchonghua0704";
        //支付成功后的服务器回调url
        public static final String notify_url = "https://www.zhaoshenma.cn:80/wcpay/wxNotify";
  //      public static final String notify_url = "http://localhost:8080/wcpay/wxNotify";

        //签名方式，固定值
        public static final String SIGNTYPE = "MD5";
//        public static final String SIGNTYPE =SignType.MD5;
        //交易类型，小程序支付的固定值为JSAPI
        public static final String TRADETYPE = "JSAPI";
        //微信统一下单接口地址
        public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";


}

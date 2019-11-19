package com.in.market.pojo.wcapplogin;

/**
 * 微信登录所返回的json对象
 */
public class WcApplogin {
    //用户唯一标识
    private String openId;
    //会话密钥
    private String session_key;
    //用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
    private String unionid;
    //错误码
    private Integer errcode;
    //错误信息
    private String errmsg;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "WcApplogin{" +
                "openId='" + openId + '\'' +
                ", session_key='" + session_key + '\'' +
                ", unionid='" + unionid + '\'' +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}

package com.allst.jcore.basic;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * url : http://smssh1.253.com/msg/send/json
 * account : N4205321
 * password : pL8tu46SI
 * @author June 2019/03/13 下午 03:07
 * @version 1.0
 */
public class Map2Json {
    public static final String charset = "utf-8";
    // 请登录zz.253.com 获取创蓝API账号(非登录账号,示例:N1234567)
    public static String account = "N4205321";
    // 请登录zz.253.com 获取创蓝API密码(非登录密码)
    public static String password = "pL8tu46SI";
    //
    public static String params = "15023424015,THJ_01,19";
    //
    public static String sendtime = "201704101400";
    public static String extend = "555";
    public static String uid = "abc123";

    public static void main(String[] args) throws UnsupportedEncodingException {

        //短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsSingleRequestServerUrl = "https://smssh1.253.com/msg/variable/json";
        // 设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
        String msg = "{$var}号梁将于{$var} 台座进行砼浇筑，请及时进行工作准备";
        //手机号码
        String phone = "15023424015";
        //状态报告
        String report= "true";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report);
//        SmsSendRequest smsSingleRequest2 = new SmsSendRequest(account, password, msg, params, sendtime, report, extend, uid);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);
    }
}

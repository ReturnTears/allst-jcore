package com.allst.jcore.basic;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author June 2019/03/13 下午 04:27
 * @version 1.0
 */
public class TestJson {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("account", "N4205321");
        map.put("password", "pL8tu46SI");
        map.put("msg", "【253云通讯】");
        map.put("phone", "15023424015");
        map.put("sendtime","2019031300");
        map.put("report", "true");
        map.put("extend", "555");
        map.put("uid", "321abc");
        String smsMsg = JSON.toJSONString(map);
        System.out.println(smsMsg);
    }

}

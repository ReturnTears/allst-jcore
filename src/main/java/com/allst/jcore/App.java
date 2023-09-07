package com.allst.jcore;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.JSON;
import com.allst.jcore.bean.User;
import com.allst.jcore.util.DynamicBeanHelper;
import com.google.common.collect.ImmutableMap;

import java.time.LocalDateTime;

/**
 * Hello world!--start study jcore part12 native method
 *
 * @author June
 * @date 2018/04/17
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        boolean needCheck = false;
        if (needCheck) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTimeUtil.now());

        dynamicBeanDemo();
    }

    private static void dynamicBeanDemo() {
        User user = new User("KangKang", "18", "Nan");
        User target = (User) DynamicBeanHelper.getTarget(user, ImmutableMap.of("address", "China BeiJin"));
        System.out.println(target.toString());
        String string = JSON.toJSONString(target);
        System.out.println(string);
    }
}

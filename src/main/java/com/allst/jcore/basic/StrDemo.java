package com.allst.jcore.basic;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Hutu
 * @since 2023-02-14 上午 09:46
 */
public class StrDemo {
    public static void main(String[] args) {
        String source = "10.187.8,10.187.9,10.187.10";
        String target = "10.187.8.123";
        String ipNetwork = target.substring(0, target.lastIndexOf("."));
        boolean result = StringUtils.contains(source, ipNetwork);
        System.out.println("result : " + result);
    }
}

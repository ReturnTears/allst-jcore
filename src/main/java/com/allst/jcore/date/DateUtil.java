package com.allst.jcore.date;

import java.util.Date;

/**
 * @author Hutu
 * @since 2023-06-08 上午 09:09
 */
public class DateUtil {
    public static void main(String[] args) {
        long time = new Date().getTime();
        long i = time / 1000 / 60 / 60 / 24 / 360;
        System.out.println(time);
        System.out.println(i);
    }
}

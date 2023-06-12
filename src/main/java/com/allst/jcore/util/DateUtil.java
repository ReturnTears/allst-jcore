package com.allst.jcore.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Hutu
 * @since 2023-06-12 上午 10:46
 */
public class DateUtil {
    public static void main(String... args) {
        long seconds = getSecondsNextEarlyMorning();
        System.out.println(seconds);
    }

    /**
     * 获取当前时间到第二天凌晨的seconds
     */
    public static Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }

    public static void getYearTimes() {
        long time = new Date().getTime();
        long i = time / 1000 / 60 / 60 / 24 / 360;
        System.out.println(time);
        System.out.println(i);
    }
}

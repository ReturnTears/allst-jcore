package com.allst.jcore.jv8;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Java 8日期相关
 * java8的时间日期API：
 * LocalDate、LocalTime、LocalDateTime、Clock、Instant这些的类的设计都使用了不变的模式，因此是线程安全的设计
 * @author June 2018-01-13 下午 10:05
 * @version 1.0
 */
public class AllstJv8Date {
    public static void main(String[] args) {
        timesInfo();
    }
    /**
     * Java 8 日期时间操作
     */
    private static void timesInfo() {
        LocalDateTime dt = LocalDateTime.now();
        // 获取年份 2018
        System.out.println(dt.getYear());
        // 获取月份 JANUARY
        System.out.println(dt.getMonth());
        // 1
        System.out.println(dt.getMonthValue());
        // 获取当前月份的某天 13
        System.out.println(dt.getDayOfMonth());
        // 获取当前年份的某天 13
        System.out.println(dt.getDayOfYear());
        // 获取时分秒 22 : 9 : 50
        System.out.println(dt.getHour() + " : " + dt.getMinute() + " : " + dt.getSecond());
        // 获取从1970年1月1日0时0分0秒当现在的毫秒数1547388590558
        System.out.println(Clock.systemDefaultZone().millis());
        // 获得本月的第一天
        System.out.println(LocalDate.of(dt.getYear(), dt.getMonth(), 1));
        //获取本月的最后一天
        System.out.println(dt.with(TemporalAdjusters.lastDayOfMonth()));
        //java8中格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.format(formatter));

        // 打印昨天的当前时刻
        System.out.println(dt.minusDays(1));

        System.out.println(LocalDate.now().toString());
    }

    /**
     * Java8以前的日期操作
     */
    public static void times() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
    }
}

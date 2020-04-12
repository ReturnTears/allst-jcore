package com.allst.jcore.jv8.date0;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author YiYa
 * @since 2020-04-12 上午 11:56
 */
public class NewDateApi {

    public static void main(String[] args) {
        aboutLocalDate();
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        aboutLocalTime();
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        aboutLocalDateTime();
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        aboutInstant();
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        aboutDuration();
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        aboutPeriod();
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        aboutDateFormat();
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        aboutDateParse();
    }

    private static void aboutLocalDate() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, 9, 1);
        System.out.println(localDate);
        System.out.println(localDate2.getYear());
        System.out.println(localDate2.getMonth());
        System.out.println(localDate2.getMonthValue());
        System.out.println(localDate2.getDayOfYear());
        System.out.println(localDate2.getDayOfMonth());
        System.out.println(localDate2.getDayOfWeek());
    }

    private static void aboutLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
    }

    private static void aboutLocalDateTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime.toString());

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    /**
     * 事件点
     */
    private static void aboutInstant() {
        Instant start = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }

    private static void aboutDuration() {
        LocalTime start = LocalTime.now();
        LocalTime end = start.minusHours(1);
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toHours());
    }

    private static void aboutPeriod() {
        LocalDate startDateInclusive = LocalDate.now();
        LocalDate endDateExclusive = LocalDate.of(2019, 1, 10);
        Period period = Period.between(startDateInclusive, endDateExclusive);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    private static void aboutDateFormat() {
        LocalDate localDate = LocalDate.now();
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(s1.trim());
        System.out.println(s2.trim());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s3 = localDate.format(formatter);
        System.out.println(s3);
    }

    private static void aboutDateParse() {
        String s1 = "20200202";
        LocalDate localDate = LocalDate.parse(s1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s2 = "2020-02-02";
        LocalDate localDate1 = LocalDate.parse(s2, formatter);
        System.out.println(localDate1);
    }
}

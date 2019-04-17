package com.allst.jcore.basic;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class SystemTime {

	public static void main(String[] args) {
		// 获取当前系统时间的毫秒数及其长度
		long time = System.currentTimeMillis();
		int len = String.valueOf(time).length();
		System.out.println("当前系统时间的毫秒数:"+time+",->其长度为:"+len);
		// 将当前时间的毫秒数转换为大致的年份
		int year = (int) (time/1000/60/60/24/365);
		// 获取当前时间的年份
		Calendar c = Calendar.getInstance();
		int curYear = c.get(Calendar.YEAR);
		int startYear = curYear-year;
		int curMonth = c.get(Calendar.MONTH)+1;
		int curDay = c.get(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DATE);
		System.out.println("系统日期是从:" + startYear + "开始!");
		System.out.println("当前日期为:" + curYear + "-" + curMonth + "-" + day);
		System.out.println(new SystemTime().getTimeStamp());
		System.out.println(curDay);
	}

	/**
	 * 获取当前时间戳的字符串
	 * @return
	 */
	private String getTimeStamp() {
		// 方法 一
		System.currentTimeMillis();
		// 方法 二
		Calendar.getInstance().getTimeInMillis();
		// 方法 三
		long stamp = new Date().getTime();
		String str = String.valueOf(stamp);
		return str;
	}
	
	/**
	 * 获取当前时间的：年、月、日、时、分、秒
	 */
	@Test
	public void timeTest() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Year : " + calendar.get(Calendar.YEAR)); // 获取当前时间的年
		System.err.println("Month : " + (calendar.get(Calendar.MONTH) + 1)); // 0-11 表示:1月到12月
		System.out.println("Date : " + calendar.get(Calendar.DATE)); // 获取当前日期
		System.err.println("Hour : " + calendar.get(Calendar.HOUR_OF_DAY)); // 获取当前小时
		System.out.println("Min : " + calendar.get(Calendar.MINUTE)); // 获取当前分钟
		System.err.println("Second : " + calendar.get(Calendar.SECOND)); // 获取当前秒
	}
	
	/**
	 * Java8获取当前时间的：年、月、日、时、分、秒
	 */
	@Test
	public void timeInfoGet() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Year :" + dt.getYear()); // 获取年份
		System.err.println("Month Upper : " + dt.getMonth());	// 获取英文大写月份
		System.out.println("Month : " + dt.getMonthValue()); // 1-12
		System.err.println("Date : " + dt.getDayOfMonth()); //获取当前日期
		System.out.println("Hour : " + dt.getHour()); // 获取当前小时
		System.err.println("Min : " + dt.getMinute()); // 获取当前分钟
		System.out.println("Second : " + dt.getSecond()); // 获取当前秒
	}
	
	/**
	 * 如何获取从1970：00：00到现在的毫秒数
	 */
	@Test
	public void getMillions() {
		long method1 = Calendar.getInstance().getTimeInMillis(); // 第一种方式
		System.out.println("方式一 ： " + method1);
		long method2 = System.currentTimeMillis(); // 第二种方式
		System.out.println("方式二：" + method2);
		long method3 = Clock.systemDefaultZone().millis(); // 第三种方式
		System.out.println("方式三：" + method3);
	}
	
	/**
	 * 获取当前月份的第一天
	 */
	@Test
	public void getLastDayOfMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date first = c.getTime();
		System.out.println(first);
	}
	
	/**
	 * java8的方式获取
	 */
	@Test
	public void getDayofMonths() {
		LocalDate date = LocalDate.now();
		LocalDate firstDay = LocalDate.of(date.getYear(), date.getMonth(), 1); // 获取本月的第一天
		System.out.println("本月的第一天  : " + firstDay);
		LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth()); // 获取本月的最后一天
		System.out.println("本月的最后一天  : " + lastDay);
		
	}
	
	/**
	 * 格式化日期
	 */
	@Test
	public void dataOfFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println("格式化前 : " + date + "\n格式化后: " + sdf.format(date));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate ld = LocalDate.now();
		System.out.println("Java8日期格式化前: " + ld + "\nJava8日期格式化后: " + ld.format(dtf));
	}
	
	/**
	 * 获取昨天的当前时间
	 */
	@Test
	public void currDateYesterday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		System.out.println(sdf.format(c.getTime()));
		
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(-1);
		System.out.println("Java8的方式获取 : " + yesterday);	
	}
	
	/**
	 * Instant是用于机器可读的时间格式，它以unix时间戳的格式存储日期时间
	 */
	@Test
	public void instantExample() {
		Instant instant = Instant.now();
		System.out.println("curr timestamp :" + instant);
		
		Instant speciliTime = Instant.ofEpochMilli(instant.toEpochMilli());
		System.out.println("specific time :" + speciliTime);
		
		Duration duration = Duration.ofDays(30);
		System.out.println(duration);
	}
	
	@Test
	public void testJava8DateApi() {
//		Date date = new Date(2018,1,1);
//		System.out.println(date);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018,1,1);
		System.out.println(calendar);
	}
}

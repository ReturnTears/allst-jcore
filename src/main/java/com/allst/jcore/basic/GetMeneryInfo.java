package com.allst.jcore.basic;

/**
 * 获取当前JVM的运行时环境
 * @author hh
 *
 */
public class GetMeneryInfo {
	public static void main(String[] args) {
		
		Runtime run = Runtime.getRuntime();
		long max = run.maxMemory();
		long total = run.totalMemory();
		long free = run.freeMemory();
		System.out.println(max/ 1024L / 1024L +"MB");
		System.out.println(total/ 1024L / 1024L +"MB");
		System.out.println(free/ 1024L / 1024L +"MB");
	}
}

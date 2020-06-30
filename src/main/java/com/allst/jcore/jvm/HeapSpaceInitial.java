package com.allst.jcore.jvm;

/**
 * -Xms600m -Xmx600m -XX:+PrintGCDetails
 *
 * @author YiYa
 * @since 2020-06-30 下午 10:14
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms : " + initialMemory + "m\n-Xmx : " + maxMemory + "m");

        // System.out.println(initialMemory * 64.0 / 1024 + "g");
        // System.out.println(maxMemory * 4.0 / 1024 + "g");
    }
}

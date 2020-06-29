package com.allst.jcore.jvm;

/**
 * 堆空间
 * 通过两个不同的类进行测试JVM进程的堆空间独享
 * @author YiYa
 * @since 2020-06-29 下午 10:48
 */
public class HeapSpace1 {
    public static void main(String[] args) {
        System.out.println("start......");
        try {
            Thread.sleep(1000001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end........");
    }
}

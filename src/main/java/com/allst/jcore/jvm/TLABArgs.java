package com.allst.jcore.jvm;

/**
 * TLAB args： 测试-XX:UseTLAB参数是否开启的情况
 * jinfo -flag UseTLAB 1524(pid)
 * -XX:+UseTLAB (+表示开启)
 * @author YiYa
 * @since 2020-07-04 上午 08:44
 */
public class TLABArgs {
    public static void main(String[] args) {
        System.out.println("TLAB Args:");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

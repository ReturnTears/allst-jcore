package com.allst.jcore.jvm;

/**
 * @author YiYa
 * @since 2020-06-21 上午 09:05
 */
public class DynamicLinking {

    public void mehtod1() {
        System.out.println("method1 ");
    }

    public void mehtod2() {
        System.out.println("method2 ");
        mehtod1();
    }
}

package com.allst.jcore.ext;

/**
 * 定义一个子类Child， 并继承Base类
 *
 * @author Hutu
 * @since 2023-10-10 下午 09:56
 */
public class Child extends Base {
    public long sum(long a, long b) {
        System.out.println("Child_long_long");
        return a + b;
    }

    public long sum(int a, long b) {
        System.out.println("Child_int_long");
        return a + b;
    }
}

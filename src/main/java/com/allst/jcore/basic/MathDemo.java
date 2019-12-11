package com.allst.jcore.basic;

/**
 * Math类中的round, ceil, floor
 * @author YiYa
 * @since 2019-12-11 下午 11:49
 */
public class MathDemo {
    public static void main(String[] args) {
        /*
         *  四舍五入的原理是在参数上加0.5然后做向下取整(适合五入的部分)。
         */
        System.out.println(Math.round(-1.4));
        System.out.println(Math.round(-1.5));
        System.out.println(Math.round(-1.6));
    }
}

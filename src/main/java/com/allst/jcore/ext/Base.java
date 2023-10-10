package com.allst.jcore.ext;

/**
 * 定义一个基类
 *
 * @author Hutu
 * @since 2023-10-10 下午 09:55
 */
public class Base {
    /*public int sum(int a, int b) {
        System.out.println("Base_int_int");
        return a + b;
    }*/

    public long sum(int a, long b) {
        System.out.println("Base_int_long");
        return a + b;
    }

    protected int currentStep;
    protected void step1() {}
    protected void step2() {}
    protected void action() {
        this.currentStep = 1;
        step1();
        this.currentStep = 2;
        step2();
    }
}

package com.allst.jcore.ext;

/**
 * @author Hutu
 * @since 2023-10-11 下午 08:50
 */
public class Child2 extends Base2 {
    public static int s;

    static {
        System.out.println("Child2 Static Code, s: " + s);
        s = 10;
    }

    private int a;

    {
        System.out.println("Child2 Instance Code, a: " + a);
        a = 10;
    }

    public Child2() {
        System.out.println("Child2 Construct Code, a: " + a);
        a = 20;
    }

    protected void step() {
        System.out.println("child s: " + s + ", a: " + a);
    }

}

package com.allst.jcore.ext;

/**
 * @author Hutu
 * @since 2023-10-11 下午 08:49
 */
public class Base2 {
    public static int s;

    static {
        System.out.println("Base2 Static Code, s: " + s);
        s = 1;
    }

    private int a;

    {
        System.out.println("Base2 Instance Code, a: " + a);
        a = 1;
    }

    public Base2() {
        System.out.println("Base2 Construct, a: " + a);
        a = 2;
    }

    protected void step() {
        System.out.println("base2 s: " + s + ", a: " + a);
    }

    public void action() {
        System.out.println("start");
        step();
        System.out.println("end");
    }
}

package com.allst.jcore.basic;

/**
 * @author Hutu
 * @since 2023-07-13 下午 11:03
 */
public class Derived extends Base {
    @Override
    public void f() {
        System.out.println("Derived f()");
    }

    @Override
    public void g() {
        System.out.println("Derived g()");
    }
}

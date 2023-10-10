package com.allst.jcore.ext;

/**
 * 这种思路和设计是一种设计模式，称之为模板方法。action方法就是一个模板方法，它定义了实现的模板，而具体实现则由子类提供。
 *
 * @author Hutu
 * @since 2023-10-10 下午 10:30
 */
public class BaseChildPermission {
    public static void main(String[] args) {
        Child c = new Child();
        c.action();
    }
}

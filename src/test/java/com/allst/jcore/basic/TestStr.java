package com.allst.jcore.basic;

/**
 * @author Hutu
 * @since 2023-11-14 上午 10:58
 */
public class TestStr {
    public static void main(String[] args) {
        build(null);
    }

    public static void build(String name) {
        if (name != null && !name.equals("")) {
            System.out.println("name : " + name);
        }
    }
}

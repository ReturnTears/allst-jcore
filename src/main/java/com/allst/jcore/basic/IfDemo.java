package com.allst.jcore.basic;

/**
 * @author Hutu
 * @since 2023-04-06 下午 05:00
 */
public class IfDemo {
    public static void main(String[] args) {
        int num = 10;
        if (num > 1) {
            System.out.println("num > 1");
        }
        if (num > 5) {
            System.out.println("num > 5");
        }
        if (num > 8) {
            System.out.println("num > 8");
        }
        if (num > 10) {
            System.out.println("num > 10");
        }
        if (num > 7) {
            System.out.println("num > 7");
        } else if (num > 9) {
            System.out.println("num > 9");
        }
    }
}

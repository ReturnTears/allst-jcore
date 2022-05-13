package com.allst.jcore.basic;

/**
 * @author June
 * @since 2022-05-13
 */
public class CommUtils {
    public static boolean func1(String str) {
        return str.toLowerCase() == "java";
    }

    public static boolean func2(String str) {
        return str.toLowerCase().equals("java");
    }
}

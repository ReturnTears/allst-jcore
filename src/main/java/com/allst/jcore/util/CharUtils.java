package com.allst.jcore.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Hutu
 * @since 2023-03-09 下午 09:59
 */
public class CharUtils {

    public static int CharToASCII(final char character) {
        return character;
    }

    /**
     * Convert the ASCII value to character
     *
     * @param ascii ascii value
     *
     * @return character value
     */
    public static char ASCIIToChar(final int ascii) {
        return (char) ascii;
    }

    public static List<String> genChar() {
        char[] c = new char[26];
        List<String> result = Lists.newArrayList();
        for (int i = 0; i < 26; i++) {
            c[i] = (char) ('a' + i);
            result.add(String.valueOf(c[i]));
        }
        return result;
    }

    public static List<String> genNumber(int num) {
        List<String> result = Lists.newArrayList();
        for (int i = 1; i <= num; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }
}

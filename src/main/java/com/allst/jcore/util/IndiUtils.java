package com.allst.jcore.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Hutu
 * @since 2023-03-09 下午 10:54
 */
public class IndiUtils {
    /**
     * 字符转ASCII码值
     */
    public static int CharToASCII(final char character) {
        return character;
    }

    /**
     * ASCII码值转字符
     */
    public static char ASCIIToChar(final int ascii) {
        return (char) ascii;
    }

    /**
     * 生成26小写字母
     */
    public static List<String> genLowerCase() {
        char[] c = new char[26];
        List<String> result = Lists.newArrayList();
        for (int i = 0; i < 26; i++) {
            c[i] = (char) ('a' + i);
            result.add(String.valueOf(c[i]));
        }
        return result;
    }

    /**
     * 生成26大写字母
     */
    public static List<String> genCapital() {
        char[] c = new char[26];
        List<String> result = Lists.newArrayList();
        for (int i = 0; i < 26; i++) {
            c[i] = (char) ('A' + i);
            result.add(String.valueOf(c[i]));
        }
        return result;
    }

    /**
     * 生成指定连续数字
     *
     * @param end 结束数字
     */
    public static List<String> genStrNumber(int end) {
        List<String> result = Lists.newArrayList();
        for (int i = 1; i <= end; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    public static List<Integer> genNumber(int end) {
        List<Integer> result = Lists.newArrayList();
        for (int i = 1; i <= end; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * 生成指定范围内的连续数字
     *
     * @param start 起始数字
     * @param end   结束数字
     */
    public static List<String> getNumber(int start, int end) {
        List<String> result = Lists.newArrayList();
        for (int i = start; i <= end; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    /**
     * 将一串数字提取为独立数字和连续数字的起止组成的字符串
     */
    public static String extractNumber(List<Integer> arr) {
        if (arr == null || arr.size() == 0) return "";
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < arr.size() - 1) {
            int j = i;
            int k = i + 1;
            while (j < arr.size() - 1 && k < arr.size() && arr.get(j) + 1 == arr.get(k)) {
                j++;
                k++;
            }
            if (j - i <= 0) {
                sb.append(arr.get(i)).append(",");
            } else {
                sb.append(arr.get(i)).append("~").append(arr.get(j)).append(",");
            }
            i = k;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String handleNumeric(int number, List<Integer> usedNumbers) {
        List<Integer> nums = genNumber(number);
        List<Integer> unUsedNums = nums.stream().filter(item -> !usedNumbers.contains(item)).collect(toList());

        return extractNumber(unUsedNums);
    }

    public static String handleString(int number, List<String> usedStrings) {
        List<String> nums = genStrNumber(number);
        List<String> chars = genLowerCase();
        nums.addAll(chars);
        List<String> unUsedString = nums.stream().filter(item -> !usedStrings.contains(item)).collect(toList());
        List<Integer> asciiList = Lists.newArrayList();
        for (String s : unUsedString) {
            int i = CharToASCII(s.charAt(0));
            asciiList.add(i);
        }
        String extractNumber = extractNumber(asciiList);
        String[] split = extractNumber.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (StringUtils.contains(s, "~")) {
                String[] s1 = s.split("~");
                sb.append(ASCIIToChar(Integer.parseInt(s1[0]))).append("~").append(ASCIIToChar(Integer.parseInt(s1[1]))).append(",");
            } else {
                sb.append(ASCIIToChar(Integer.parseInt(s))).append(",");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        /*List<String> usedStrings = Lists.newArrayList("1", "2", "6", "7", "8", "a", "b", "c", "d", "h","j","z");
        String str = handleString(9, usedStrings);
        System.out.println("Result : " + str);*/

        List<Integer> usedNumbers = Lists.newArrayList(1, 2, 6, 7, 8, 100, 190, 203, 400, 500,700,888);
        String str = handleNumeric(999, usedNumbers);
        System.out.println("Result : " + str);
    }
}

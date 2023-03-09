package com.allst.jcore.basic;

import com.allst.jcore.util.CharUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Hutu
 * @since 2023-03-09 下午 10:00
 */
public class CalcChar {
    public static void main(String[] args) {
        // 生成26个小写字母
        List<String> chars = CharUtils.genChar();
        // 生成数字
        List<String> nums = CharUtils.genNumber(9);
        nums.addAll(chars);
        // 已经使用的字符: [1,2,6,7,8,a,b,c,d,z]
        List<String> usedChar = Lists.newArrayList("1", "2", "6", "7", "8", "a", "b", "c", "d", "z");
        // 求两个集合差集， nums - used, 可用的字符
        List<String> results = nums.stream().filter(item -> !usedChar.contains(item)).collect(toList());
        // System.out.println(results);
        // 字符转换为ASCII码值
        List<Integer> params = Lists.newArrayList();
        for (String s : results) {
            int i = CharUtils.CharToASCII(s.charAt(0));
            params.add(i);
        }
        // System.out.println(params);
        // 转换为连续的ASCII码值
        String sort = CalcNumber.sort(params);
        System.out.println(sort);
        // 转换为字符结果
        String[] split = sort.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (StringUtils.contains(s, "~")) {
                String[] s1 = s.split("~");
                sb.append(CharUtils.ASCIIToChar(Integer.parseInt(s1[0]))).append("~").append(CharUtils.ASCIIToChar(Integer.parseInt(s1[1]))).append(",");
            } else {
                sb.append(CharUtils.ASCIIToChar(Integer.parseInt(s))).append(",");
            }
        }
        String str = sb.substring(0, sb.length() - 1);
        System.out.println(str);
    }


}

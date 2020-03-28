package com.allst.jcore.jv8.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 常用方法（函数 / API） ~ filter
 *
 * @author YiYa
 * @since 2020-03-28 下午 06:31
 */
public class StreamFilter {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 6);
        // 取偶数
        List<Integer> collect = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        // 去重
        List<Integer> collect1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);

        // 跳过n个元素
        List<Integer> collect2 = list.stream().skip(5).collect(Collectors.toList());
        System.out.println(collect2);

        // limit同MySQL
        List<Integer> collect3 = list.stream().limit(5).collect(Collectors.toList());
        System.out.println(collect3);

    }

}

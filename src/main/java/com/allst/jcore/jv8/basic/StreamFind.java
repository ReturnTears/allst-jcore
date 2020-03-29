package com.allst.jcore.jv8.basic;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 常用方法（函数 / API） ~ find
 *
 * @author YiYa
 * @since 2020-03-29 上午 11:02
 */
public class StreamFind {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};

        // findAny | get
        Stream<Integer> anyStream = Arrays.stream(arr);
        Optional<Integer> any = anyStream.filter(a -> a > 1).findAny();
        System.out.println(any.get());

        // findAny | orElse
        Stream<Integer> elseStream = Arrays.stream(arr);
        Optional<Integer> any1 = elseStream.filter(a -> a > 4).findAny();
        System.out.println(any1.orElse(-1));

        // findFirst
        Stream<Integer> firstStream = Arrays.stream(arr);
        Optional<Integer> first = firstStream.filter(a -> a % 2 == 0).findFirst();
        System.out.println(first);
        first.ifPresent(System.out::println);
        System.out.println(first.filter(i -> i == 2).get());


        // 自定义find
        int i = find(arr, -1, a -> a < 10);
        System.out.println(i);
    }

    private static int find(Integer[] values, int defaultValue, Predicate<Integer> predicate) {
        for (int i : values) {
            if (predicate.test(i)) {
                return i;
            }
        }
        return defaultValue;
    }

}

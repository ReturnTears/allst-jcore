package com.allst.jcore.jv8.basic;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 常用方法（函数 / API） ~ reduce
 *
 * @author YiYa
 * @since 2020-03-29 上午 11:27
 */
public class StreamReduce {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};

        // reduce
        Stream<Integer> stream = Arrays.stream(arr);
        Integer reduce = stream.reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        // reduce
        Stream<Integer> stream2 = Arrays.stream(arr);
        stream2.reduce((a, b) -> a + b).ifPresent(System.out::println);

        // reduce sum
        Stream<Integer> stream3 = Arrays.stream(arr);
        Integer reduceSum = stream3.reduce(0, Integer::sum);
        System.out.println(reduceSum);

        // reduce max
        Stream<Integer> stream4 = Arrays.stream(arr);
        stream4.reduce(Integer::max).ifPresent(System.out::println);

        // reduce min
        Stream<Integer> stream5 = Arrays.stream(arr);
        stream5.reduce(Integer::min).ifPresent(System.out::println);

    }

}

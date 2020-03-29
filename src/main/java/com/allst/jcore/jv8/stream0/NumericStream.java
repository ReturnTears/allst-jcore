package com.allst.jcore.jv8.stream0;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * int类型比Integer类型节省内存空间
 * @author YiYa
 * @since 2020-03-29 下午 10:00
 */
public class NumericStream {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        // Integer
        Stream<Integer> stream = Arrays.stream(arr);
        Integer reduce = stream.filter(a -> a.intValue() > 3).reduce(0, Integer::sum);
        System.out.println(reduce);

        // Integer -> int
        Stream<Integer> integerStream = Arrays.stream(arr);
        int sum = integerStream.mapToInt(a -> a.intValue()).filter(a -> a > 3).sum();
        System.out.println(sum);

        // int -> integer
        int a = 9;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a = " + r[0] + ", b = " + r[1] + ", c = " + r[2]));
        System.out.println();
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a = " + r[0] + ", b = " + r[1] + ", c = " + r[2]));

    }

}

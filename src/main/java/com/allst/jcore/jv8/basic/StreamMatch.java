package com.allst.jcore.jv8.basic;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 常用方法（函数 / API） ~ match
 *
 * @author YiYa
 * @since 2020-03-29 上午 10:41
 */
public class StreamMatch {

    public static void main(String[] args) {
        // allMatch
        Stream<Integer> integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean match = integerStream.allMatch(a -> a > 0);
        assert match : "all elements is not greater zero ~"; // 需要增加 jvm 参数 -ea

        // anyMatch
        Stream<Integer> integerStream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean b = integerStream2.anyMatch(a -> a > 6);
        assert b : "all elements is less than six ~";   // 需要增加 jvm 参数 -ea

        // noneMatch
        Stream<Integer> integerStream3 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean noneMatch = integerStream3.noneMatch(a -> a < 0);
        assert noneMatch : "at least one elements less than zero~";
    }

}

package com.allst.jcore.jv8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * @author YiYa
 * @since 2020-04-01 下午 11:08
 */
public class CustomerCollectorAction {

    public static void main(String[] args) {
        Collector<String, List<String>, List<String>> collector = new ToListCollector<>();
        String[] arr = new String[]{"Hello", "world", "Java", "Stream"};
        List<String> list = Arrays.stream(arr)
                .filter(s -> s.length() > 4)
                .collect(collector);
        //System.out.println(list);

        List<String> list2 = Arrays.asList("Hello", "world", "Java", "Stream")
                .parallelStream()
                .filter(s -> s.length() > 4)
                .collect(collector);
        System.out.println(list2);
    }

}

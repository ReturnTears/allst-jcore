package com.allst.jcore.jv8.collector;

import com.allst.jcore.jv8.stream0.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

// 这种方式是被动调用该类, 不会被初始化的，不会占用任何内存， 去掉final关键字就是主动加载
import static com.allst.jcore.jv8.collector.CollectorsAction.list;

/**
 * @author YiYa
 * @since 2020-03-31 下午 10:25
 */
public class CollectorsAction2 {

    public static void main(String[] args) {
        testGroupingByConcurrentWithFunction();

        testGroupingByConcurrentWithFunctionAndCollector();

        testGroupingByConcurrentWithFunctionAndSupplierAndCollector();

        testJoining();

        testJoiningWithDelimiter();

        testJoiningWithDelimiterAndPrefixAndSuffix();

        testMapping();

        testMaxby();

        testMinby();
    }

    private static void testGroupingByConcurrentWithFunction() {
        ConcurrentMap<Dish.Type, List<Dish>> collect = list.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
    }

    private static void testGroupingByConcurrentWithFunctionAndCollector() {
        ConcurrentMap<Dish.Type, Double> collect = list.stream().
                collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
    }

    private static void testGroupingByConcurrentWithFunctionAndSupplierAndCollector() {
        ConcurrentMap<Dish.Type, Double> collect = list.stream().collect(Collectors.groupingByConcurrent(Dish::getType,
                ConcurrentSkipListMap::new,
                Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);


        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
    }

    /**
     * joining()
     */
    private static void testJoining() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().map(Dish::getName).collect(Collectors.joining()))
                .ifPresent(System.out::println);
    }

    private static void testJoiningWithDelimiter() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().map(Dish::getName).collect(Collectors.joining(",")))
                .ifPresent(System.out::println);
    }

    private static void testJoiningWithDelimiterAndPrefixAndSuffix() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().map(Dish::getName).collect(Collectors.joining(",", "Namw[", "]")))
                .ifPresent(System.out::println);
    }

    private static void testMapping() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(","))))
                .ifPresent(System.out::println);
    }

    private static void testMaxby() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        list.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testMinby() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        list.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }
}

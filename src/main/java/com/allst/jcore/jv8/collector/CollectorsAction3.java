package com.allst.jcore.jv8.collector;

// 这种方式是被动调用该类, 不会被初始化的，不会占用任何内存， 去掉final关键字就是主动加载

import com.allst.jcore.jv8.stream0.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.allst.jcore.jv8.collector.CollectorsAction.list;

/**
 * @author YiYa
 * @since 2020-04-01 下午 08:50
 */
public class CollectorsAction3 {

    public static void main(String[] args) {
        testPartitionByWithPredicate();

        testPartitionByWithPredicateAndCollector();

        testReducingBinaryOperate();

        testReducingBinaryOperatorAndIdenty();

        testReducingBinaryOperatorAndIdentyAndFunction();

        testSummarizingInt();

        testSummarizingLong();

        testSummarizingDouble();
    }

    private static void testPartitionByWithPredicate() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Map<Boolean, List<Dish>> listMap = list.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.of(listMap).ifPresent(System.out::println);
    }

    private static void testPartitionByWithPredicateAndCollector() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Map<Boolean, Double> listMap = list.stream().
                collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingDouble(Dish::getCalories)));
        Optional.of(listMap).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperate() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        list.stream().collect(
                Collectors.reducing(
                        BinaryOperator.maxBy(
                                Comparator.comparingInt(Dish::getCalories)
                        )
                )
        ).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdenty() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Integer result = list.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        System.out.println(result);
    }

    private static void testReducingBinaryOperatorAndIdentyAndFunction() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Integer result = list.stream().collect(Collectors.reducing(0, Dish::getCalories, (d1, d2) -> d1 + d2));
        System.out.println(result);
    }

    private static void testSummarizingInt() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.summarizingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testSummarizingLong() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.summarizingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testSummarizingDouble() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.summarizingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);
    }
}

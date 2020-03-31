package com.allst.jcore.jv8.collector;

import com.allst.jcore.jv8.stream0.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YiYa
 * @since 2020-03-30 下午 10:30
 */
public class CollectorsAction {

    public final static List<Dish>  list = Arrays.asList(
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("salmon", false, 450, Dish.Type.FISH),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER));

    public static void main(String[] args) {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        List<Dish> rice = list.stream().filter(a -> a.getName().equals("rice")).collect(Collectors.toList());
        Optional.ofNullable(rice).ifPresent(System.out::println);

        testAveragingDouble();

        testAveragingInt();

        testAveragingLong();

        testCollectorAndThen();

        testCounting();

        testGroupingByFunction();

        testGroupingByFunctionAndCollector();

        testGroupingByFunctionAndSupplierAndCollector();

        testSummarizingInt();
    }

    /**
     * averagingDouble方法
     */
    private static void testAveragingDouble() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.ofNullable(list.stream().collect(Collectors.averagingDouble(Dish::getCalories)))
            .ifPresent(System.out::println);
    }

    /**
     * averagingInt
     */
    private static void testAveragingInt() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.ofNullable(list.stream().collect(Collectors.averagingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    /**
     * averagingLong
     */
    private static void testAveragingLong() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.ofNullable(list.stream().collect(Collectors.averagingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testCollectorAndThen() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.ofNullable(list.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), a -> " >> " + a)))
            .ifPresent(System.out::println);

        List<Dish> l = list.stream().filter(d -> d.getType().equals(Dish.Type.MEAT))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        System.out.println(l);
    }

    private static void testCounting() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    private static void testGroupingByFunction() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.groupingBy(Dish::getType)))
                .ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndCollector() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories))))
                .ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndSupplierAndCollector() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Map<Dish.Type, Double> map = list.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));

        Optional.of(map.getClass()).ifPresent(System.out::println);
        Optional.of(map).ifPresent(System.out::println);
    }

    private static void testSummarizingInt() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        IntSummaryStatistics result = list.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.of(result).ifPresent(System.out::println);
    }
}

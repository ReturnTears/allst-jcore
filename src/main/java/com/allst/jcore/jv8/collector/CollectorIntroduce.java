package com.allst.jcore.jv8.collector;

import com.allst.jcore.jv8.basic.Apple;
import com.allst.jcore.jv8.stream0.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YiYa
 * @since 2020-03-30 下午 09:42
 */
public class CollectorIntroduce {

    public static void main(String[] args) {
        List<Apple> applesList = Arrays.asList(new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170)
                , new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170)
        );
        List<Apple> greenList = applesList.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
        Optional.ofNullable(greenList).ifPresent(System.out::println);
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");

        // lambda
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.ofNullable(groupByColor(applesList)).ifPresent(System.out::println);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.ofNullable(groupByFunction(applesList)).ifPresent(System.out::println);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.ofNullable(groupByCollector(applesList)).ifPresent(System.out::println);

    }

    /**
     * 传统的方法对苹果按照颜色分组
     *
     * @param list 参数
     * @return 结果
     */
    private static Map<String, List<Apple>> groupByColor(List<Apple> list) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple a : list) {
            List<Apple> list1 = map.get(a.getColor());
            if (null == list1) {
                list1 = new ArrayList<>();
                map.put(a.getColor(), list1);
            }
            list1.add(a);
        }
        return map;
    }

    /**
     * 使用Java 8 的方式
     * @param apples
     * @return
     */
    private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        apples.stream().forEach(a -> {
            List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
               List<Apple> list = new ArrayList<>();
               map.put(a.getColor(), list);
               return list;
            });
            colorList.add(a);
        });
        return map;
    }

    /**
     * Collectors的方式
     * @param apples 参数
     * @return 结果
     */
    private static Map<String, List<Apple>> groupByCollector(List<Apple> apples) {
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
        // 下面的方式也可以， 更加简单
        // return apples.stream().collect(groupingBy(Apple::getColor));
    }

}

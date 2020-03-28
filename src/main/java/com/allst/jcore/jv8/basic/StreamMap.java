package com.allst.jcore.jv8.basic;

import com.allst.jcore.jv8.stream0.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 常用方法（函数 / API） ~ map & flatMap（扁平化）
 *
 * @author YiYa
 * @since 2020-03-29 上午 12:16
 */
public class StreamMap {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 6);
        List<Integer> collect = list.stream().map(a -> a * 3).collect(Collectors.toList());
        System.out.println(collect);

        // map
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        listDish().stream().map(a -> a.getName()).forEach(System.out::println);

        // map
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        List<String> collect1 = listDish().stream().map(a -> a.getName()).collect(Collectors.toList());
        System.out.println(collect1);

        // flatMap
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        String[] words = {"Hello Stream", "Hi Java"};
        List<String> collect2 = Arrays.stream(words).map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(collect2);

    }

    private static List<Dish> listDish() {
        List<Dish> menu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH),
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER));
        return menu;
    }
}

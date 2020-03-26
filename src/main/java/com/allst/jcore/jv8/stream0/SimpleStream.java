package com.allst.jcore.jv8.stream0;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Stream
 *
 * @author YiYa
 * @since 2020-03-26 下午 10:48
 */
public class SimpleStream {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        List<String> dishNamesByCollections = getDishNamesByCollections(menu);
        System.out.println(dishNamesByCollections);

        List<String> dishNamesByStream = getDishNamesByStream(menu);
        System.out.println(dishNamesByStream);
    }

    /* 传统方式 */
    private static List<String> getDishNamesByCollections(List<Dish> menu) {
        List<Dish> lowCalories = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCalories.add(dish);
            }
        }
        // Collections.sort(lowCalories, (d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));
        Collections.sort(lowCalories, Comparator.comparingInt(Dish::getCalories));
        List<String> dishNameList = new ArrayList<>();
        for (Dish d : lowCalories) {
            dishNameList.add(d.getName());
        }
        return dishNameList;
    }

    private static List<String> getDishNamesByStream(List<Dish> menu) {
        return menu.stream().filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}

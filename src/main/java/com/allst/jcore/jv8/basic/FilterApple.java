package com.allst.jcore.jv8.basic;

import com.allst.jcore.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 过滤🍎
 *
 * @author YiYa
 * @since 2020-03-23 下午 11:31
 */
public class FilterApple {
    /**
     * 过滤green apple
     *
     * @param apples apple
     * @return 结果
     */
    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 如果我们想过滤其他color的apple怎么办呢？
     *
     * @param apples apple集合
     * @param color  颜色
     * @return 结果
     */
    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("green", 190),
                new Apple("red", 220), new Apple("yellow", 230));
        /*List<Apple> greenApples = findGreenApple(list);
        // 断言
        assert greenApples.size() == 1 : "~error~";
        System.out.println(greenApples);*/

        List<Apple> greenApples = findApple(list, "green");
        System.out.println(greenApples);

        List<Apple> redApples = findApple(list, "red");
        System.out.println(redApples);

    }

}

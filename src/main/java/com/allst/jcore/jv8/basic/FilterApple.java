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

    /*
     * 参数的变化代表需求的变化
     * 如果我们又想在颜色的基础上添加重量的需求呢? ? ?
     *
     * 使用策略模式
     *
     */
    public interface AppleFilter {
        boolean filter(Apple apple);

        default void print(String var) {
            System.out.println(var);
        }
    }

    public static  List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }

        return list;
    }


    public static class GreenAnd200WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return ("green".equals(apple.getColor()) && apple.getWeight() >= 200);
        }
    }

    public static class yellowLess300WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return ("yellow".equals(apple.getColor()) && apple.getWeight() < 300);
        }
    }




    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 250), new Apple("green", 190),
                new Apple("red", 220), new Apple("yellow", 230));
        /*List<Apple> greenApples = findGreenApple(list);
        // 断言
        assert greenApples.size() == 1 : "~error~";
        System.out.println(greenApples);*/

        List<Apple> greenApples = findApple(list, "green");
        System.out.println(greenApples);

        List<Apple> redApples = findApple(list, "red");
        System.out.println(redApples);

        List<Apple> result = findApple(list, new GreenAnd200WeightFilter());
        System.out.println(result);
        // 匿名内部类的方式
        List<Apple> yellowList = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });

        System.out.println(yellowList);


        // 使用简单lambda表达式, 一个参数的时候JVM会进行参数的类型推导
        List<Apple> lambdaResult = findApple(list, apple -> "green".equals(apple.getColor()));
        System.out.println(lambdaResult);
    }

}

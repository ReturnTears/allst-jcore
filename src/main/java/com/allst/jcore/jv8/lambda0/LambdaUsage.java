package com.allst.jcore.jv8.lambda0;

import com.allst.jcore.jv8.basic.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * lambda表达式应用
 * @author YiYa
 * @since 2020-03-24 下午 11:09
 */
public class LambdaUsage {

    public static void main(String[] args) {
        // lambda expression的使用
        Runnable r1 = () -> System.out.println("Hello Lambda");
        // 等同于下面
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello Lambda"));

        // -----------------------
        List<Apple> appleList = Arrays.asList(new Apple("green", 220), new Apple("red", 300));
        List<Apple> applesResult = filter(appleList, (apple) -> "red".equals(apple.getColor()));
        System.out.println(applesResult);

        List<Apple> apples = filterAppleByWeight(appleList, w -> w > 200);
        System.out.println(apples);

    }

    private static void process(Runnable r) {
        r.run();
    }


    private static List<Apple> filter(List<Apple> resoure, Predicate<Apple> predicate) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : resoure) {
            if (predicate.test(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    private static List<Apple> filterAppleByWeight(List<Apple> resoure, LongPredicate predicate) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : resoure) {
            if (predicate.test(apple.getWeight())) {
                list.add(apple);
            }
        }
        return list;
    }


    /**
     * 是一个functioninterface
     */
    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    /**
     * 是一个functioninterface, 继承了是一个FunctionInterface, 并且没有自己的抽象方法
     */
    public interface SmartAdder extends Adder {

    }

}

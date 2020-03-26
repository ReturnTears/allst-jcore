package com.allst.jcore.jv8.lambda0;

import com.allst.jcore.jv8.basic.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * @author YiYa
 * @since 2020-03-25 下午 11:19
 */
public class MethodReference {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        useConsumer(consumer, "Hello ~");
        useConsumer(s -> System.out.println(s), "Hi ~");
        useConsumer(System.out::println, "Hello ~ Hi");

        List<Apple> list = Arrays.asList(new Apple("yellow", 107), new Apple("pink", 109), new Apple("red", 120));
        System.out.println(list);

        // list.sort((a, b) -> a.getColor().compareTo(b.getColor()));
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);

        // list.stream().forEach(a -> System.out.println(a));
        list.stream().forEach(System.out::println);

        Function<String, Integer> f = Integer::parseInt;
        Integer result = f.apply("123");
        System.out.println(result);

        BiFunction<String, Integer, Character> f2 = String::charAt;
        Character c = f2.apply("Hello", 2);
        System.out.println(c);

        String string = "Hello~";
        Function<Integer, Character> f3 = string::charAt;
        Character c2 = f3.apply(4);
        System.out.println(c2);

        Supplier<String> stringSupplier = String::new;
        String s = stringSupplier.get();
        System.out.println(s);

        BiFunction<String, Long, Apple> appleBiFunction = Apple::new;
        Apple red = appleBiFunction.apply("Red", 1000L);
        System.out.println(red);

        ThreeFunction<String, Long, String, ComplexApple> threeFunction = ComplexApple::new;
        ComplexApple complexApple = threeFunction.apply("Green", 123L, "红富士");
        System.out.println(complexApple);

    }


    private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}

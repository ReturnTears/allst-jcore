package com.allst.jcore.genericity.demo2;

import java.util.List;

/**
 * 定义Apple类型时使用了泛型
 *
 * 该程序定义了一个带泛型声明的Apple<T>类（不要理会这个类型形参是否具有实际意义），
 * 使用Apple<T>类时就可为T类型形参传入实际类型，这样就可以生成如Apple<String>、Apple<Double>…形式的多个逻辑子类（物理上并不存在）。
 *
 * @author Hutu
 * @since 2024-03-18 下午 10:23
 */
public class Apple<T> {
    private T info;

    public Apple() {
    }

    public Apple(T info) {
        this.info = info;
    }

    public static void main(String... args) {
        Apple<String> apple = new Apple<>("apple");
        System.out.println(apple.getInfo());

        Apple<Double> doubleApple = new Apple<>(18.20);
        System.out.println(doubleApple.getInfo());

        List<String> list = List.of("apple", "banana", "orange");
        doubleApple.test(list);

        List<Double> doubleList = List.of(1.0, 2.0, 3.0);
        apple.test(doubleList);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void test(List<?> list) {
        list.forEach(System.out::println);
    }
}

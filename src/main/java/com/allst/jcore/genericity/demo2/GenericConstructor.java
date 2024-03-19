package com.allst.jcore.genericity.demo2;

/**
 * 正如泛型方法允许在方法签名中声明类型形参一样，Java也允许在构造器签名中声明类型形参，
 * 这样就产生了所谓的泛型构造器
 *
 * @author Hutu
 * @since 2024-03-19 下午 10:22
 */
public class GenericConstructor {

    public static void main(String... args) {
        new Foo("hello world");
        new Foo(18);
        new Foo(18.25);
        new <String> Foo("Hi Generic");
    }

}

class Foo {
    public <T>  Foo(T t) {
        System.out.println(t);
    }
}

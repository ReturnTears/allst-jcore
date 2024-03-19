package com.allst.jcore.genericity.demo2;

/**
 * @author Hutu
 * @since 2024-03-19 下午 10:45
 */
public class GenericDiamond {
    public static void main(String[] args) {
        /*
         * MyClass类声明中的E形参是String类型
         * 泛型构造器中声明的T形参是Integer类型
         */
        MyClass<String> myClass = new MyClass<>(18);
        // 显示指定泛型构造器中声明的T形参是Integer类型
        MyClass<String> myClass2 = new <Integer> MyClass<String>(20);

        /*
         * MyClass类声明中的E形参是String类型
         * 如果显示指定泛型构造器中声明的T形参是Integer类型
         * 此时就不能使用'<>'语法，
         * 下行注释的代码是错误的
         */
        //MyClass<String> myClass3 = new <Integer> MyClass<>(20);
    }
}

class MyClass<E> {
    public <T> MyClass(T t) {
        System.out.println("t param value is : " + t);
    }
}

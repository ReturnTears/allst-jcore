package com.allst.jcore.genericity.demo1;

/**
 * @author Hutu
 * @since 2023-11-02 下午 11:26
 */
public class WildcardSample<T> {
    T obj;

    public static void main(String... args) {
        ExtendSample<Parent> sample1 = new ExtendSample<Parent>();
        ExtendSample<Sub1> sample2 = new ExtendSample<Sub1>();
        ExtendSample<? extends Parent> sample3 = new ExtendSample<Sub1>();
        ExtendSample<? extends Sub1> sample4;
        sample1.obj = new Sub1();
        //sample3.obj = new Parent();//编译错误,因为只能读， 不能写

        SuperSample<? super Parent> super1 = new SuperSample<Parent>();
        // 编译错误，只能存放Parent或他的父类
        // SuperSample<? super Parent> super2 = new SuperSample<Sub1>();
        SuperSample<? super Sub1> super3 = new SuperSample<Parent>();

        super1.obj = new Sub1();
        super1.obj = new Sub2();
        super1.obj = new Parent();

        super3.obj = new Sub1();
        //super3.obj = new Parent(); //编译错误
    }

    void test() {
        WildcardSample<Parent> sample1 = new WildcardSample<Parent>();
        // WildcardSample<Parent> sample2 = new WildcardSample<Sub1>();// 编译错误

        // 正常编译
        WildcardSample<?> sample3 = new WildcardSample<Parent>();
        WildcardSample<?> sample4 = new WildcardSample<Sub1>();
        WildcardSample<?> sample5 = new WildcardSample<Sub2>();

        sample1.obj = new Sub1();
        // sample3.obj = new Sub1();//编译错误
        // sample4.obj = new Sub1();

        sample1.test();
    }
}

class Parent {
}

class Sub1 extends Parent {
}

class Sub2 extends Parent {
}

/**
 * 有上界的泛型类
 */
class ExtendSample<T extends Parent> {
    T obj;

    /**
     * 有上界的泛型方法
     */
    <K extends Sub1> T extendMethod(K param) {
        return this.obj;
    }
}

class SuperSample<T> {
    T obj;
}


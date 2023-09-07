package com.allst.jcore.basic;

/**
 * @author Hutu
 * @since 2023-07-13 下午 11:05
 *
 * 由于子类可以覆盖父类的方法，因此同样的方法会在父类与子类中有着不同的表现形式。
 * 在Java语言中，基类的引用变量不仅可以指向基类的实例对象，也可以指向其子类的实例对象。
 * 同样，接口的引用变量也可以指向其实现类的实例对象。而程序调用的方法在运行期才动态绑定（绑定指的是将一个方法调用和一个方法主体连接到一起），
 * 就是引用变量所指向的具体实例对象的方法，也就是内存里正在运行的那个对象的方法，而不是引用变量的类型中定义的方法。
 * 通过这种动态绑定的方法实现了多态。由于只有在运行时才能确定调用哪个方法，因此通过方法覆盖实现的多态也可以被称为运行时多态
 *
 * 下例中，由于子类Derived的f()方法和g()方法与父类Base的方法同名，因此Derived的方法会覆盖Base的方法。
 * 在执行Base b=new Derived()语句的时候，会调用Base类的构造函数，而在Base的构造函数中，执行了g()方法，
 * 由于Java语言的多态特性，此时会调用子类Derived的g()方法，而非父类Base的g()方法，因此会输出Derived g()。
 * 由于实际创建的是Derived类的对象，后面的方法调用都会调用子类Derived的方法
 */
public class BaseDemo {
    /**
     * 运行结果：
     * Derived g()
     * Derived f()
     * Derived g()
     */
    public static void main(String[] args) {
        Base b = new Derived();
        b.f();
        b.g();
    }
}

package com.allst.jcore.ext;

/**
 * @author Hutu
 * @since 2023-10-10 下午 10:02
 */
public class BaseChildApp {
    /**
     * Child和Base都定义了sum方法，这里调用的是哪个sum方法呢？子类的sum方法参数类型虽然不完全匹配但是是兼容的，
     * 父类的sum方法参数类型是完全匹配的。程序输出为: Base_int_int
     *
     * 将Base类中修改方法为:sum(int a, long b)。程序输出为: Base_int_long
     *
     * 将Child类的方法修改为:sum(int a, long b)。程序输出为: Child_int_long
     *
     * 结论：当有多个重名函数的时候，在决定要调用哪个函数的过程中，首先是按照参数类型进行匹配的，
     * 换句话说，寻找在所有重载版本中最匹配的，然后才看变量的动态类型，进行动态绑定。
     */
    public static void main(String... args) {
        Child c = new Child();
        int a = 2;
        int b = 3;
        c.sum(a, b);
    }
}

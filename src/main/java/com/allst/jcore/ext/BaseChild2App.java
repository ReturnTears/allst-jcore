package com.allst.jcore.ext;

/**
 * 运行结果如下：
 * ---- new Child()
 * Base2 Static Code, s: 0
 * Child2 Static Code, s: 0
 * Base2 Instance Code, a: 0
 * Base2 Construct, a: 1
 * Child2 Instance Code, a: 0
 * Child2 Construct Code, a: 10
 * <p>
 * ---- c.action()
 * start
 * child s: 10, a: 20
 * end
 * <p>
 * ---- b.action()
 * start
 * child s: 10, a: 20
 * end
 * <p>
 * ---- b.s: 1
 * <p>
 * ---- c.s: 10
 *
 * @author Hutu
 * @since 2023-10-11 下午 08:51
 */
public class BaseChild2App {
    public static void main(String... args) {
        System.out.println("---- new Child()");
        Child2 c = new Child2();
        System.out.println("\n---- c.action()");
        c.action();
        Base2 b = c;
        System.out.println("\n---- b.action()");
        b.action();
        System.out.println("\n---- b.s: " + Base2.s);
        System.out.println("\n---- c.s: " + Child2.s);
    }
}

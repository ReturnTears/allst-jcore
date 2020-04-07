package com.allst.jcore.jv8.default0;

/**
 * default method
 *
 * @author YiYa
 * @since 2020-04-07 下午 10:59
 */
public class DefaultInAction {

    public static void main(String[] args) {
        A a = () -> 10;
        System.out.println(a.size());
        System.out.println(a.inEmpty());

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        DefaultInAction action = new DefaultInAction();
        int[] arr = null;
        Object o = arr;
        action.confuse(o);      // 引用的是 confuse(Object o) 方法， 因为参数类型更具体，更接近于Object
        // action.confuse(null); // 引用的是 confuse(int[] i) 方法, 因为参数类型更具体

        D d = new D();
        d.hello();
    }

    private interface B {
        default void hello() {
            System.out.println("=== B ===");
        }
    }

    private interface C extends B {
        @Override
        default void hello() {
            System.out.println("=== C ===");
        }
    }

    /**
     * class的优先级最高~ > 子接口的优先级 > 自己重写
     */
    private static class D implements B, C {
        /*@Override
        public void hello() {
            System.out.println("=== D ===");
        }*/
    }

    private interface A {
        int size();

        default boolean inEmpty() {
            return size() == 0;
        }
    }

    private void confuse(Object o) {
        System.out.println("Object.");
    }

    private void confuse(int[] i) {
        System.out.println("int[].");
    }
}

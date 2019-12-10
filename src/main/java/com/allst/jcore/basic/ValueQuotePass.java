package com.allst.jcore.basic;

/**
 * 值传递和引用传递
 * @author YiYa
 * @since 2019-12-10 下午 11:30
 */
public class ValueQuotePass {
    public static void main(String[] args) {
        new ValueQuotePass().test();
    }

    private void test() {
        int i = 11;
        StringBuffer sb = new StringBuffer("Hello");
        testPassParams(sb, i);
        System.out.println(sb);
        System.out.println(i);
    }

    private static void testPassParams(StringBuffer sb, int n) {
        //System.out.println(n);
        sb.append(" World");    // 引用
        n = 22;                 // 值
    }
}

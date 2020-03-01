package com.allst.jcore.basic;

/**
 * 可变参数
 * @author YiYa
 * @since 2020-03-01 下午 11:56
 */
public class VariableParams {

    public static void main(String[] args) {
        VariableParams params = new VariableParams();
        params.show(12);
        params.show("Hello");
        params.show("hello", "world");
    }

    private void show(int i) {
        System.out.println(i);
    }

    private void show(String arg) {
        System.out.println(arg);
    }

    private void show(String ...strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s).append("~");
        }
        System.out.println(sb.toString());
    }
}

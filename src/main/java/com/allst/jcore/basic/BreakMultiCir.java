package com.allst.jcore.basic;

/**
 * Break Multi Circulation(跳出多重循环):
 * 在循环体外指定一个标记 flag
 * continue flag;//是跳过当前这一层循环，执行下一次循环。
 * break flag; //指的是跳出整个循环。
 *
 * @author June 2018-01-13 下午 09:50
 * @version 1.0
 */
public class BreakMultiCir {
    public static void main(String[] args) {
        flag:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i = " + i + ", " + "j = " + j);
                if (j == 2) {
                    continue flag;
                }
                if (i == 4) {
                    break flag;
                }
            }
            System.out.println("i = " + i);
        }
        System.out.println("end.");
    }
}

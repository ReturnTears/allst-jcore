package com.allst.jcore.basic;

/**
 * 无符号数的右移操作
 * @author YiYa
 * @since 2019-12-11 下午 11:57
 */
public class RightShift {
    public static void main(String[] args) {
        int i = -4;
        System.out.println(Integer.toBinaryString(i));
        // 右移一位
        i >>= 1;
        System.out.println(Integer.toBinaryString(i));
        // 在Java语言中, 为了保证移动位数的有效性, 以使右移的位数不超过32bit, 采用了取余4操作, a >> n 等价于 a >> (n % 32)
        i = -4;
        i >>= (1 % 32);
        System.out.println(Integer.toBinaryString(i));
        //
        i = -4;
        i >>>= 1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
    }
}

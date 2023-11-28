package com.allst.jcore.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 这里计算数学相关的
 *
 * @author Hutu
 * @since 2023-11-27 下午 11:11
 */
public class Client {
    public static void main(String[] args) {
        calcInterest();
    }

    /**
     * 计算精度
     */
    public static void calcPrecision() {
        NumberFormat f = new DecimalFormat("#.##");
        System.out.println(f.format(10.00 - 9.60)); // 0.4
    }

    /**
     * 计算利息
     */
    public static void calcInterest() {
        //存款
        BigDecimal d = new BigDecimal(888888);
        //月利率，乘3计算季利率
        BigDecimal r = BigDecimal.valueOf(0.001875 * 3);
        //计算利息
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("季利息是：" + i);
    }
}

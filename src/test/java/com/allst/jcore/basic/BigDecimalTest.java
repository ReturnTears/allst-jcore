package com.allst.jcore.basic;

import java.math.BigDecimal;

/**
 * @author June
 * @since 2022-06-14
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal param = null;
        boolean equals = a.equals(param);
        System.out.println(equals);
    }
}

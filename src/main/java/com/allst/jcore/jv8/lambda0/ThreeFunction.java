package com.allst.jcore.jv8.lambda0;

/**
 * @author YiYa
 * @since 2020-03-26 下午 10:37
 */
@FunctionalInterface
public interface ThreeFunction<T, U, K, R> {

    R apply(T t, U u, K k);

}

package com.allst.jcore.vavr;

import io.vavr.concurrent.Future;
import io.vavr.control.Option;
import io.vavr.control.Try;

/**
 * Introduction to Future in Vavr
 *
 * @author June
 * @since 2021年07月
 */
public class FutureInVavr {
    public static void main(String... args) {
        String initialValue = "Welcome to ";
        Future<String> resultFuture = Future.of(() -> someComputation());
        // 如果需要等待结果，get()方法会阻塞当前线程
        System.out.println(resultFuture.get());

        // 推荐使用getOrElse
        String resultValue = resultFuture.getOrElse("Failed to get underlying value.");
        System.out.println(resultValue);

        // 一种不同的方法是调用非阻塞getValue()方法，该方法返回一个Option<Try<T>>
        Option<Try<String>> futureOption = resultFuture.getValue();
        Try<String> futureTry = futureOption.get();
        String result = futureTry.get();
        System.out.println(result);
        System.out.println(resultFuture.isEmpty());
    }

    private static String someComputation() {
        return "Hello Vavr ~^~";
    }
}

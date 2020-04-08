package com.allst.jcore.jv8.future0;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author YiYa
 * @since 2020-04-08 下午 11:40
 */
public class CompletableFutureInAction {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
        CompletableFuture completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            double value = get();
            completableFuture.complete(value);
        }).start();

        System.out.println("=======block.");
        completableFuture.whenComplete((v, t) -> {
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(System.out::println);
        });
        // Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);
    }

    private static double get() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RANDOM.nextDouble();
    }
}

package com.allst.jcore.jv8.future0;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author YiYa
 * @since 2020-04-12 上午 09:30
 */
public class CompletableFutureInAction2 {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean result = new AtomicBoolean(false);
        ExecutorService service = Executors.newFixedThreadPool(2, r -> {
            Thread t = new Thread(r);
            t.setDaemon(false);
            return t;
        });

        CompletableFuture.supplyAsync(CompletableFutureInAction::get, service)
                .whenComplete((v, t) -> {
                    Optional.of(v).ifPresent(System.out::println);
                    Optional.of(t).ifPresent(x -> x.printStackTrace());
                });

        System.out.println("-------------------");
        /*Thread.currentThread().join();*/
    }
}

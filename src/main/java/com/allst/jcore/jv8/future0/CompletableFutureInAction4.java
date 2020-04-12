package com.allst.jcore.jv8.future0;

import java.util.concurrent.CompletableFuture;

/**
 * @author YiYa
 * @since 2020-04-12 上午 11:30
 */
public class CompletableFutureInAction4 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " is running 1......");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).runAfterBoth(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " is running 2......");
            return  2;
        }),() -> System.out.println("Done"));
    }
}

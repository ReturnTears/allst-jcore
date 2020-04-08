package com.allst.jcore.jv8.future0;

import java.util.concurrent.*;

/**
 * @author YiYa
 * @since 2020-04-08 下午 11:02
 */
public class FutureInAction2 {
    public static void main(String[] args) {
        // 线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(6000L);
                return "I am finished.";
            } catch (InterruptedException e) {
                return "I am error.";
            }
        });

        try {
            //System.out.println(future.get(10, TimeUnit.MICROSECONDS));
            while (!future.isDone()) {
                Thread.sleep(10);
            }
            System.out.println(future.get());
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

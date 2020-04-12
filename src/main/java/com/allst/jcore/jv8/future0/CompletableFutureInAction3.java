package com.allst.jcore.jv8.future0;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author YiYa
 * @since 2020-04-12 上午 10:38
 */
public class CompletableFutureInAction3 {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean result = new AtomicBoolean(false);
        ExecutorService service = Executors.newFixedThreadPool(2, r -> {
            Thread t = new Thread(r);
            t.setDaemon(false);
            return t;
        });

        /*CompletableFuture.supplyAsync(CompletableFutureInAction::get, service)
                .thenApply(CompletableFutureInAction3::mutlipy)
                .whenComplete((v, t) -> {
                    Optional.of(v).ifPresent(System.out::println);
                    Optional.of(t).ifPresent(x -> x.printStackTrace());
                });*/

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<CompletableFuture<Double>> completableFutureStream = list.stream().map(i ->
                CompletableFuture.supplyAsync(() -> queryProduction(i), service));
        Stream<CompletableFuture<Double>> a = completableFutureStream.map(f -> f.thenApply(CompletableFutureInAction3::mutlipy));
        List<Double> resulta = a.map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(resulta);
    }

    private static double mutlipy(double value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * 2;
    }

    private static double queryProduction(int i) {
        return CompletableFutureInAction.get();
    }
}

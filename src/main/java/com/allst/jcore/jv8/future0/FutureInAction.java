package com.allst.jcore.jv8.future0;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author YiYa
 * @since 2020-04-08 下午 10:11
 */
public class FutureInAction {
    public static void main(String[] args) {
        Futrue<String> futrue = invoke(() -> {
           try {
               Thread.sleep(10000);
               return "I am finished.";
           } catch (InterruptedException e) {
               return "Error";
           }
        });
        assert futrue != null;
        System.out.println(futrue.get());
        System.out.println(futrue.get());
        System.out.println(futrue.get());
    }

    private static <T> Futrue<T> invoke(Callable<T> callable) {
        AtomicReference<T> reference = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);
        Thread t = new Thread(() -> {
            T value = callable.action();
            reference.set(value);
        });
        t.start();
        Futrue<T> futrue = new Futrue<T>() {
            @Override
            public T get() {
                return reference.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };
        return null;
    }

    private interface Futrue<T> {
        T get();
        boolean isDone();
    }

    private interface  Callable<T> {
        T action();
    }
}

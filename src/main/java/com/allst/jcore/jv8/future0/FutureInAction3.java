package com.allst.jcore.jv8.future0;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author YiYa
 * @since 2020-04-08 下午 11:15
 */
public class FutureInAction3 {
    public static void main(String[] args) {
        // 注册一个事件

    }

    private static <T> Futrue<T> invoke(Callable<T> callable) {
        AtomicReference<T> reference = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);
        Futrue<T> futrue = new Futrue<T>() {
            private Completable<T> completable;
            @Override
            public T get() {
                return reference.get();
            }
            @Override
            public boolean isDone() {
                return finished.get();
            }

            @Override
            public void setCompletable(Completable<T> completable) {
                this.completable = completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return completable;
            }
        };
        Thread t = new Thread(() -> {
            try {
                T value = callable.action();
                reference.set(value);
                finished.set(true);
                if (futrue.getCompletable() != null) {
                    futrue.getCompletable().complete(value);
                }
            } catch (Throwable cause) {
                if (futrue.getCompletable() != null) {
                    futrue.getCompletable().exception(cause);
                }
            }
        });
        t.start();
        //
        return futrue;
    }

    private interface Futrue<T> {
        T get();
        boolean isDone();
        void setCompletable(Completable<T> completable);
        Completable<T> getCompletable();
    }

    private interface  Callable<T> {
        T action() throws InterruptedException;
    }

    private interface Completable<T> {
        void complete(T t);
        void exception(Throwable cause);
    }
}

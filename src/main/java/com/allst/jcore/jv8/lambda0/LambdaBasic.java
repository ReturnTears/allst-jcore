package com.allst.jcore.jv8.lambda0;

/**
 * @author YiYa
 * @since 2020-03-24 上午 12:57
 */
public class LambdaBasic {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(args.length);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        // 修改为lambda表达式
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        // 由于线程在main主线程中运行， 有可能执行不到，
        Thread.currentThread().join();

    }

}

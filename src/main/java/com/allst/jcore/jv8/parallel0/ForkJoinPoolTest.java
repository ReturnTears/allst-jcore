package com.allst.jcore.jv8.parallel0;

import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoinPool
 *
 * @author YiYa
 * @since 2020-04-02 下午 11:13
 */
public class ForkJoinPoolTest {

    private static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static void main(String[] args) {
        System.out.println("for calc result = " + calc());

        // ForkJoinPool
        AccumulatorRecursiveTask task = new AccumulatorRecursiveTask(0, data.length, data);
        ForkJoinPool pool = new ForkJoinPool();
        Integer result = pool.invoke(task);
        System.out.println("forkjoinpool calc result = " + result);

        //
        AccumullatorRecursiveAction action = new AccumullatorRecursiveAction(0, data.length, data);
        pool.invoke(action);
        System.out.println("recursiveAction calc result = " + AccumullatorRecursiveAction.AccumulatorHelper.getResult());
    }

    private static int calc() {
        int result = 0;
        for (int i : data) {
            result += i;
        }
        return result;
    }

}

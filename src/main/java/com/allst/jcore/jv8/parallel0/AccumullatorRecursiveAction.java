package com.allst.jcore.jv8.parallel0;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * RecursiveAction
 * @author YiYa
 * @since 2020-04-02 下午 11:32
 */
public class AccumullatorRecursiveAction extends RecursiveAction {

    private final int start;

    private final int end;

    private final int[] data;

    private final int LIMIT = 3;

    public AccumullatorRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if ((end - start) <= LIMIT) {
            for (int i = start; i < end; i++) {
                AccumulatorHelper.accumulate(data[i]);
            }
        } else {
            int mid = (start + end) / 2;
            AccumullatorRecursiveAction left = new AccumullatorRecursiveAction(start, mid, data);
            AccumullatorRecursiveAction right = new AccumullatorRecursiveAction(mid, end, data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }
    }

    static class AccumulatorHelper {

        private static final AtomicInteger result = new AtomicInteger(0);

        public static int getResult() {
            return result.get();
        }

        static void accumulate(int value) {
            result.getAndAdd(value);
        }
    }
}

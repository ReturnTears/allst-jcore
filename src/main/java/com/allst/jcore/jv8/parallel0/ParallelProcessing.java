package com.allst.jcore.jv8.parallel0;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Java 8 并行执行
 *
 * @author YiYa
 * @since 2020-04-02 下午 10:22
 */
public class ParallelProcessing {

    public static void main(String[] args) {
        // 计算计算即的核心数
        // System.out.println(Runtime.getRuntime().availableProcessors());
        // 全局的ForkJoin
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
        /**
         * 10_000_000 量级下normalAdd和parallelStream的执行时间不相上下
         * 100_000_000 量级下normalAdd明显比parallelStream的执行时间慢
         * 为什么在并行的条件下还这么慢呢？并不是所有的数据结构在并行下执行都是讨喜的。
         *
         */
        System.out.println("the normalAdd best process time = " + measureSumPerformance(ParallelProcessing::normalAdd, 100_000_000) + " ms");
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        System.out.println("the iterStream best process time = " + measureSumPerformance(ParallelProcessing::iterStream, 100_000_000) + " ms");
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        System.out.println("the parallelStream best process time = " + measureSumPerformance(ParallelProcessing::parallelStream4, 100_000_000) + " ms");
    }

    /**
     * 性能测试
     * @param adder 函数名
     * @param limit 限制量
     * @return 结果
     */
    private static long measureSumPerformance(Function<Long, Long> adder,  long limit) {
        long fastest = Long.MAX_VALUE;
        for (int i =0; i < 10;i++) {
            long startTimestamp = System.currentTimeMillis();
            long result = adder.apply(limit);
            long duration = System.currentTimeMillis() - startTimestamp;
            if (duration < fastest) fastest = duration;
            // System.out.printf("执行的结果为: %d, 执行的时间为: %d \n", result, duration);

        }
        return fastest;
    }

    private static long parallelStream(long limit) {
        return Stream.iterate(1L, i -> i + 1)
                .parallel()     // 并行化
                .limit(limit)
                .reduce(0L, Long::sum);
    }

    private static long parallelStream2(long limit) {
        return Stream.iterate(1L, i -> i + 1)
                .mapToLong(Long::intValue)  // 拆箱
                .parallel()     // 并行化
                .limit(limit)
                .reduce(0L, Long::sum);
    }

    /**
     * 并行并且使用LongStream
     * @param limit 限制量
     * @return 结果
     */
    private static long parallelStream3(long limit) {
        return LongStream.rangeClosed(1L, limit).reduce(1L, Long::sum);
    }

    private static long parallelStream4(long limit) {
        return LongStream.rangeClosed(1L, limit).sum();
    }

    private static long iterStream(long limit) {
        return Stream.iterate(1L, i -> i + 1).limit(limit).reduce(0L, Long::sum);
    }

    private static long normalAdd(long limit) {
        long result = 0L;
        for (long i = 0L; i < limit; i++) {
            result += i;
        }
        return result;
    }

}

package com.allst.jcore.jv8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义toList
 *
 * @author YiYa
 * @since 2020-04-01 下午 10:57
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    private void log(String log) {
        System.out.println(Thread.currentThread().getName() + " ~ " + log);
    }

    @Override
    public Supplier<List<T>> supplier() {
        log("supplier");
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        log("accumulator");
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        log("combiner");
        return (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        log("finisher");
        return  t -> t;
        // return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        log("characteristics");
        return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH, Characteristics.IDENTITY_FINISH));
    }
}

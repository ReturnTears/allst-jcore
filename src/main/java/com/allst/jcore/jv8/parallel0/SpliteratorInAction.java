package com.allst.jcore.jv8.parallel0;

import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author YiYa
 * @since 2020-04-07 下午 10:08
 */
public class SpliteratorInAction {

    static String text = "Hello! This is a java book!"
            + "\n"
            + "Hei! this is a javascript book"
            + "\n"
            + "Hei! this is a python book";

    public static void main(String[] args) {
        /*IntStream intStream = IntStream.rangeClosed(0, 10);
        Spliterator.OfInt s = intStream.spliterator();
        Consumer<Integer> consumer = System.out::println;
        s.forEachRemaining(consumer);*/

        // 使用自定义的Spliterator
        MySpliteratorText mySpliteratorText = new MySpliteratorText(text);
        Optional.of(mySpliteratorText.parallelStream().count())
                .ifPresent(System.out::println);
        mySpliteratorText.parallelStream().filter(s -> !s.equals("")).forEach(System.out::println);
        // mySpliteratorText.stream().filter(s -> !s.equals("")).forEach(System.out::println);
    }

    /**
     * 自定义Spliterator
     */
    static class MySpliteratorText {
        private final String[] data;

        public MySpliteratorText(String text) {
            Objects.requireNonNull(text, "the parameter can not be null.");
            this.data = text.split("\n");
        }

        public Stream<String> stream() {
            return StreamSupport.stream(new MySpliterator(), false);
        }

        /**
         * 并行
         */
        public Stream<String> parallelStream() {
            return StreamSupport.stream(new MySpliterator(), true);
        }

        private class MySpliterator implements Spliterator<String> {
            private int start, end;

            public MySpliterator(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public MySpliterator() {
                this.start = 0;
                this.end = MySpliteratorText.this.data.length - 1;
            }

            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                if (start <= end) {
                    action.accept(MySpliteratorText.this.data[start++]);
                    return true;
                }
                return false;
            }

            @Override
            public Spliterator<String> trySplit() {
                int mid = (end - start) / 2;
                if (mid < 2) {
                    return null;
                }
                int left = start;
                int right = start + mid;
                start = start + mid + 1;
                return new MySpliterator(left, right);
            }

            @Override
            public long estimateSize() {
                return end - start;
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED | SUBSIZED;
            }
        }
    }
}

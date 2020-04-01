package com.allst.jcore.jv8.collector;

import com.allst.jcore.jv8.stream0.Dish;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static com.allst.jcore.jv8.collector.CollectorsAction.list;

/**
 * @author YiYa
 * @since 2020-04-01 下午 09:36
 */
public class CollectorsAction4 {

    public static void main(String[] args) {
        testSummingDouble();

        testSummingLong();

        testSummingInt();

        testToCollect();

        testToConcurrentmap();

        testToConcurrentMapWithBinaryOpertor();

        testToConcurrentMapWithBinaryOpertorAndSupplier();

        testToList();

        testToMap();

        testToSet();
    }


    private static void testSummingDouble() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.summingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);

        Optional.of(list.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum())
                .ifPresent(System.out::println);
    }

    private static void testSummingLong() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.summingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testSummingInt() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.summingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testToCollect() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().filter(d -> d.getCalories() > 600)
                .collect(Collectors.toCollection(ArrayList::new))).ifPresent(System.out::println);
    }

    private static void testToConcurrentmap() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.toConcurrentMap(Dish::getName, Dish::getCalories)))
                .ifPresent(a -> {
                        System.out.println(a.getClass());
                        System.out.println(a);

                    }
                );
    }

    private static void testToConcurrentMapWithBinaryOpertor() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.toConcurrentMap(Dish::getType, v -> 1L, (a, b) -> a + b)))
                .ifPresent(v -> {
                            System.out.println(v);
                            System.out.println(v.getClass());
                        }
                );
    }

    private static void testToConcurrentMapWithBinaryOpertorAndSupplier() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().collect(Collectors.toConcurrentMap(Dish::getType,
                v -> 1L, (a, b) -> a + b, ConcurrentSkipListMap::new)))
                .ifPresent(v -> {
                            System.out.println(v);
                            System.out.println(v.getClass());
                        }
                );
    }

    private static void testToList() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().filter(Dish::isVegetarian).collect(Collectors.toList()))
                .ifPresent(r -> {
                            System.out.println(r);
                            System.out.println(r.getClass());
                        }
                );
    }

    private static void testToMap() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().filter(Dish::isVegetarian).collect(Collectors.toMap(Dish::getName, Dish::getCalories)))
                .ifPresent(r -> {
                            System.out.println(r);
                            System.out.println(r.getClass());
                        }
                );
    }

    private static void testToSet() {
        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional.of(list.stream().filter(Dish::isVegetarian).collect(Collectors.toSet()))
                .ifPresent(r -> {
                    System.out.println(r);
                    System.out.println(r.getClass());
                });
    }

    private static void testToList2() {

    }

    private static void testToList3() {

    }
}

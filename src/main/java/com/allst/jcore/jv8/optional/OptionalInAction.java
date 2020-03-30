package com.allst.jcore.jv8.optional;

import java.util.Optional;

/**
 * @author YiYa
 * @since 2020-03-30 下午 09:18
 */
public class OptionalInAction {

    public static void main(String[] args) {
        String result = getInstanceNameByOptional(null);
        System.out.println(result);

        Optional.ofNullable(getInstanceNameByOptional(null)).ifPresent(System.out::println);
    }

    private static String getInstanceNameByOptional(Person person) {
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }
}

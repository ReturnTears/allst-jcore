package com.allst.jcore.jv11.basic.c_inheritance;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:17
 */
public class Car extends Vehicle {
    private final int passengersCount;

    public Car(int passengersCount, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.passengersCount = passengersCount;
    }

    public int getPassengersCount() {
        return this.passengersCount;
    }
}

package com.allst.jcore.jv11.basic.c_inheritance5;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:57
 */
public class Car extends Vehicle {
    private final int passengersCount;

    public Car(int passengersCount, int weightPounds, int horsePower) {
        super(weightPounds + passengersCount * 250, horsePower);
        this.passengersCount = passengersCount;
    }

    public int getPassengersCount() {
        return this.passengersCount;
    }
}

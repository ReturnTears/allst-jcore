package com.allst.jcore.jv11.basic.a_classes;

/**
 * @author Hutu
 * @since 2023-03-14 下午 10:23
 */
public class Car extends Vehicle {
    private final int passengersCount;

    public Car(int passengersCount, int weightPounds, Engine engine) {
        super(weightPounds, engine);
        this.passengersCount = passengersCount;
    }

    public int getPassengersCount() {
        return this.passengersCount;
    }
}

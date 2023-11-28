package com.allst.jcore.jv11.basic.c_inheritance3;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:37
 */
public class Car extends Vehicle {
    private final int passengersCount;
    private final int weightPounds;

    public Car(int passengersCount, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.passengersCount = passengersCount;
        this.weightPounds = weightPounds;
    }

    public int getPassengersCount() {
        return this.passengersCount;
    }

    public double getSpeedMph(double timeSec) {
        int weight = this.weightPounds + this.passengersCount * 250;
        return getSpeedMph(timeSec, weight);
    }
}

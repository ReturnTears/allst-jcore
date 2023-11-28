package com.allst.jcore.jv11.basic.c_inheritance3;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:24
 */
public class Vehicle {
    private final int weightPounds;
    private final int horsePower;

    public Vehicle(int weightPounds, int horsePower) {
        this.weightPounds = weightPounds;
        this.horsePower = horsePower;
    }

    public double getSpeedMph(double timeSec, int weightPounds) {
        double v = 2.0 * this.horsePower * 746;
        v = v * timeSec * 32.174 / weightPounds;
        return Math.round(Math.sqrt(v) * 0.68);
    }
}

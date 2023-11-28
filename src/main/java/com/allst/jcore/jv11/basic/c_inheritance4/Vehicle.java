package com.allst.jcore.jv11.basic.c_inheritance4;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:48
 */
public abstract class Vehicle {
    private final int weightPounds;
    private final int horsePower;

    public Vehicle(int weightPounds, int horsePower) {
        this.weightPounds = weightPounds;
        this.horsePower = horsePower;
    }

    public abstract int getMaxWeightPounds();

    public double getSpeedMph(double timeSec) {
        double v = 2.0 * this.horsePower * 746;
        v = v * timeSec * 32.174 / getMaxWeightPounds();
        return Math.round(Math.sqrt(v) * 0.68);
    }
}

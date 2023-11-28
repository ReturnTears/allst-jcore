package com.allst.jcore.jv11.basic.c_inheritance3;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:36
 */
public class Truck extends Vehicle {
    private final int payload;
    private final int weightPounds;

    public Truck(int payloadPounds, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.payload = payloadPounds;
        this.weightPounds = weightPounds;
    }

    public int getPayload() {
        return this.payload;
    }

    public double getSpeedMph(double timeSec) {
        int weight = this.weightPounds + this.payload;
        return getSpeedMph(timeSec, weight);
    }
}

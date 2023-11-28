package com.allst.jcore.jv11.basic.c_inheritance2;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:15
 */
public class Truck extends Vehicle {
    private final int payload;
    private final int weightPounds;
    private final int horsePower;

    public Truck(int payloadPounds, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.payload = payloadPounds;
        this.weightPounds = weightPounds;
        this.horsePower = horsePower;
    }

    public int getPayload() {
        return this.payload;
    }

    public double getSpeedMph(double timeSec) {
        int weight = this.weightPounds + this.payload;
        double v = 2.0 * this.horsePower * 746;
        v = v * timeSec * 32.174 / weight;
        return Math.round(Math.sqrt(v) * 0.68);
    }
}

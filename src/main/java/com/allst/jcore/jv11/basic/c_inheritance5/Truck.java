package com.allst.jcore.jv11.basic.c_inheritance5;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:56
 */
public class Truck extends Vehicle {
    private final int payload;

    public Truck(int payloadPounds, int weightPounds, int horsePower) {
        super(weightPounds + payloadPounds, horsePower);
        this.payload = payloadPounds;
    }

    public int getPayload() {
        return this.payload;
    }
}

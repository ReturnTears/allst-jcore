package com.allst.jcore.jv11.basic.c_inheritance;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:15
 */
public class Truck extends Vehicle {
    private final int payload;
    public Truck(int payloadPounds, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.payload = payloadPounds;
    }

    public int getPayload() {
        return payload;
    }
}

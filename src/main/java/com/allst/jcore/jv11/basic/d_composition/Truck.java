package com.allst.jcore.jv11.basic.d_composition;

/**
 * @author Hutu
 * @since 2023-11-28 下午 11:11
 */
public class Truck extends Vehicle {
    private final int payload;
    private final int weightPounds;

    public Truck(int payloadPounds, int weightPounds, int horsePower) {
        super(weightPounds + payloadPounds, horsePower);
        this.payload = payloadPounds;
        this.weightPounds = weightPounds;
    }

    public int getPayload() {
        return this.payload;
    }
}

package com.allst.jcore.jv11.basic.d_composition;

/**
 * @author Hutu
 * @since 2023-11-28 下午 11:11
 */
public class Vehicle {
    private SpeedModel speedModel;
    private final int weightPounds;
    private final int horsePower;

    public Vehicle(int weightPounds, int horsePower) {
        this.weightPounds = weightPounds;
        this.horsePower = horsePower;
    }

    public void setSpeedModel(SpeedModel speedModel) {
        this.speedModel = speedModel;
    }

    public double getSpeedMph(double timeSec) {
        return this.speedModel.getSpeedMph(timeSec, weightPounds, horsePower);
    }
}

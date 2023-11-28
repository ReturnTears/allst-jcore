package com.allst.jcore.jv11.basic.d_composition;

import java.util.Properties;

/**
 * @author Hutu
 * @since 2023-11-28 下午 11:12
 */
public class DMain {
    public static void main(String[] args) {
        double timeSec = 10.0;
        int horsePower = 246;
        int vehicleWeight = 4000;

        Properties drivingConditions = new Properties();
        drivingConditions.put("roadCondition", "Wet");
        drivingConditions.put("tireCondition", "New");
        SpeedModel speedModel = new SpeedModel(drivingConditions);

        Car car = new Car(4, vehicleWeight, horsePower);
        car.setSpeedModel(speedModel);
        System.out.println("Car speed (" + timeSec + " sec) = " + car.getSpeedMph(timeSec) + " mph");
    }
}

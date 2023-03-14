package com.allst.jcore.jv11.basic.a_classes;

/**
 * @author Hutu
 * @since 2023-03-14 下午 10:31
 */
public class AMain {
    public static void main(String... args) {
        double timeSec = 10.0;
        int engineHorsePower = 246;
        int vehicleWeightPounds = 4000;

        Engine engine = new Engine();
        engine.setHorsePower(engineHorsePower);

        Vehicle vehicle = new Vehicle(vehicleWeightPounds, engine);
        System.out.println("Vehicle speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");

        vehicle = new Car(4, vehicleWeightPounds, engine);

        System.out.println("Car speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");

    }
}

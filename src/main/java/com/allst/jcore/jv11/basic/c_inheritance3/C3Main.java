package com.allst.jcore.jv11.basic.c_inheritance3;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:18
 */
public class C3Main {
    public static void main(String[] args) {
        double timeSec = 10.0;
        int engineHorsePower = 246;
        int vehicleWeightPounds = 4000;

        Car car = new Car(4, vehicleWeightPounds, engineHorsePower);
        System.out.println("Passengers count=" + car.getPassengersCount());
        System.out.println("Car speed (" + timeSec + " sec) = " + car.getSpeedMph(timeSec) + " mph");

        Truck truck = new Truck(3300, vehicleWeightPounds, engineHorsePower);
        System.out.println("Payload=" + truck.getPayload() + " pounds");
        System.out.println("Truck speed (" + timeSec + " sec) = " + truck.getSpeedMph(timeSec) + " mph");
    }
}

package com.allst.jcore.jv11.basic.c_inheritance2;

/**
 * @author Hutu
 * @since 2023-11-28 下午 10:18
 */
public class C2Main {
    public static void main(String[] args) {
        double timeSec = 10.0;
        int engineHorsePower = 246;
        int vehicleWeightPounds = 4000;

        Vehicle vehicle = new Car(4, vehicleWeightPounds, engineHorsePower);
        System.out.println("Passengers count=" + ((Car) vehicle).getPassengersCount());
        System.out.println("Car speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");

        vehicle = new Truck(3300, vehicleWeightPounds, engineHorsePower);
        System.out.println("Payload=" + ((Truck) vehicle).getPayload() + " pounds");
        System.out.println("Truck speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");
    }
}

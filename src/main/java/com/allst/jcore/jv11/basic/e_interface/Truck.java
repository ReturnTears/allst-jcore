package com.allst.jcore.jv11.basic.e_interface;

/**
 * @author Hutu
 * @since 2023-11-28 下午 11:25
 */
public interface Truck extends Vehicle {
    static int convertKgToPounds(int kilograms) {
        return (int) Math.round(2.205 * kilograms);
    }

    int getPayloadPounds();

    default int getPayloadKg() {
        return convertPoundsToKg(getPayloadPounds());
    }

    default int getWeightKg(int pounds) {
        return convertPoundsToKg(pounds);
    }

    private int convertPoundsToKg(int pounds) {
        return (int) Math.round(0.454 * pounds);
    }
}

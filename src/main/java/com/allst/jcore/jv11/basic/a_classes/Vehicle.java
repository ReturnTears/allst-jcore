package com.allst.jcore.jv11.basic.a_classes;

/**
 * @author Hutu
 * @since 2023-03-14 下午 10:24
 */
public class Vehicle {
    private final int weightPounds;
    private final Engine engine;

    public Vehicle(int weightPounds, Engine engine) {
        this.weightPounds = weightPounds;
        if (engine == null) {
            throw new RuntimeException("Engine value is not set.");
        }
        this.engine = engine;
    }

    public int getWeightPounds() {
        return weightPounds;
    }

    public Engine getEngine() {
        return engine;
    }

    protected double getSpeedMph(double timeSec) {
        double v = 2.0 * this.engine.getHorsePower() * 746;
        v = v * timeSec * 32.174 / this.weightPounds;
        return Math.round(Math.sqrt(v) * 0.68);
    }
}

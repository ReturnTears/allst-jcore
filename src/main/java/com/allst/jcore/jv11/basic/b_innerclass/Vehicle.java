package com.allst.jcore.jv11.basic.b_innerclass;

/**
 * @author Hutu
 * @since 2023-03-14 下午 10:58
 */
public class Vehicle {
    private final int weightPounds;
    private final Engine engine;

    public Vehicle(int weightPounds, int horsePower) {
        this.weightPounds = weightPounds;
        this.engine = new Engine(horsePower);
    }

    public double getSpeedMph(double timeSec) {
        double v = 2.0 * this.engine.getHorsePower() * 746;
        v = v * timeSec * 32.174 / this.weightPounds;
        return Math.round(Math.sqrt(v) * 0.68);
    }

    private class Engine {
        private final int horsePower;

        private Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        public int getHorsePower() {
            return horsePower;
        }
    }
}

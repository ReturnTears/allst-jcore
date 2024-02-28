package com.allst.jcore.jv11.basic.e_interface;

/**
 * @author Hutu
 * @since 2023-11-28 下午 11:35
 */
public class FactoryVehicle {
    private static abstract class VehicleImpl implements Vehicle {
        private SpeedModel speedModel;
        private final int weightPounds;
        private final int horsePower;

        private VehicleImpl(int weightPounds, int horsePower) {
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

    private static class CarImpl extends VehicleImpl implements Car {
        private final int passengersCount;

        private CarImpl(int passengersCount, int weightPounds, int horsePower) {
            super(weightPounds + passengersCount * 250, horsePower);
            this.passengersCount = passengersCount;
        }

        public int getPassengersCount() {
            return this.passengersCount;
        }
    }
}

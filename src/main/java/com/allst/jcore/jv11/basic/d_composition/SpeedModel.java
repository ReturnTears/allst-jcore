package com.allst.jcore.jv11.basic.d_composition;

import java.util.Properties;

/**
 * @author Hutu
 * @since 2023-11-28 下午 11:07
 */
public class SpeedModel {
    private final Properties conditions;

    public SpeedModel(Properties drivingConditions) {
        this.conditions = drivingConditions;
    }

    public double getSpeedMph(double timeSec, int weightPounds, int horsePower) {
        String road = conditions.getProperty("roadCondition", "Dry");
        String tire = conditions.getProperty("tireCondition", "New");
        double v = 2.0 * horsePower * 746;
        v = v * timeSec * 32.174 / weightPounds;
        return Math.round(Math.sqrt(v) * 0.68) - (road.equals("Dry") ? 2 : 5) - (tire.equals("New") ? 0 : 5);
    }
}

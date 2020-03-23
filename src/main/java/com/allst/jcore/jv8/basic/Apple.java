package com.allst.jcore.jv8.basic;

/**
 * 🍎实体类
 * @author YiYa
 * @since 2020-03-23 下午 11:31
 */
public class Apple {

    private String color;
    private long weight;

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

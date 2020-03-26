package com.allst.jcore.jv8.lambda0;

/**
 * @author YiYa
 * @since 2020-03-26 下午 10:35
 */
public class ComplexApple
{

    private String color;

    private Long weight;

    private String name;

    public ComplexApple(String color, Long weight, String name) {
        this.color = color;
        this.weight = weight;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public Long getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ComplexApple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}

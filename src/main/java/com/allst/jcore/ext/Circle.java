package com.allst.jcore.ext;

/**
 * 圆（Circle）继承自Shape，但包括了额外的属性：中心点和半径，以及额外的方法area，用于计算面积，另外，重写了draw方法
 *
 * @author Hutu
 * @since 2023-10-09 下午 10:46
 */
public class Circle extends Shape {
    //中心点
    private final Point center;
    //半径
    private final double r;

    public Circle(Point center, double r) {
        this.center = center;
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("draw circle at " + center.toString() + " with r " + r
                + ", using color : " + getColor());
    }

    public double area() {
        return Math.PI * r * r;
    }

}

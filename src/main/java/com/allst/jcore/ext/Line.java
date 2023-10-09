package com.allst.jcore.ext;

/**
 * @author Hutu
 * @since 2023-10-09 下午 10:55
 */
public class Line extends Shape {
    private final Point start;
    private final Point end;

    public Line(Point start, Point end, String color) {
        super(color);
        this.start = start;
        this.end = end;
    }

    public double length() {
        return start.distance(end);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public void draw() {
        System.out.println("draw line from " + start.toString() + " to " + end.toString() + ", using color " + super.getColor());
    }

}

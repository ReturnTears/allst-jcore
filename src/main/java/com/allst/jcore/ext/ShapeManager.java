package com.allst.jcore.ext;

/**
 * @author Hutu
 * @since 2023-10-09 下午 11:01
 */
public class ShapeManager {
    private static final int MAX_NUM = 100;
    private final Shape[] shapes = new Shape[MAX_NUM];
    private int shapeNum = 0;

    public void addShape(Shape shape) {
        if (shapeNum < MAX_NUM) {
            shapes[shapeNum++] = shape;
        }
    }

    public void draw() {
        for (int i = 0; i < shapeNum; i++) {
            shapes[i].draw();
        }
    }

}

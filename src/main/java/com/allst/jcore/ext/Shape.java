package com.allst.jcore.ext;

/**
 * 图行类
 * <p>
 * 所有图形（Shape）都有一个表示颜色的属性，有一个表示绘制的方法
 *
 * @author Hutu
 * @since 2023-10-09 下午 10:43
 */
public class Shape {
    private static final String DEFAULT_COLOR = "black";
    private String color;

    public Shape() {
        this(DEFAULT_COLOR);
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("draw shape");
    }

}

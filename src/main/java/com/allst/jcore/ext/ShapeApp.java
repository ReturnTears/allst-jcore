package com.allst.jcore.ext;

/**
 * 图形类Main方法
 *
 * @author Hutu
 * @since 2023-10-09 下午 10:49
 */
public class ShapeApp {
    /*public static void main(String... args) {
        Point center = new Point(2, 3);
        //创建圆，赋值给circle
        Circle circle = new Circle(center, 2);
        //调用draw方法，会执行Circle的draw方法
        circle.draw();
        //输出圆面积
        System.out.println(circle.area());
    }*/

    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();
        manager.addShape(new Circle(new Point(4, 4), 3));
        manager.addShape(new Line(new Point(2, 3), new Point(3, 4), "green"));
        manager.addShape(new ArrowLine(new Point(1, 2), new Point(5, 5), "black", false, true));
        manager.draw();
    }
}

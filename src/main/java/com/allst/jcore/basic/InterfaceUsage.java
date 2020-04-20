package com.allst.jcore.basic;

interface Flyable {
    // 全局常量， 第一速度,接口中常量可以省略public static final
    int MAX_SPEED = 7900;
    int MIN_SPEED = 1;
    // 方法省略了public abstract
    void fly();
    void stop();
}
interface Attrack {
    void attack();
}

/**
 * 接口
 * @author YiYa
 * @since 2020-04-20 下午 10:50
 */
public class InterfaceUsage {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        Plane plane = new Plane();
        plane.fly();
        plane.stop();

        PaperKite paperKite = new PaperKite();
        paperKite.fly();
        paperKite.stop();

        Flyable f = new PaperKite();
        f.stop();
    }
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("🍎🍎fly🍎🍎");
    }

    @Override
    public void stop() {
        System.out.println("🍎🍎stop🍎🍎");
    }
}

abstract class Kite implements Flyable, Attrack  {
    @Override
    public void fly() {
        System.out.println("...Kite fly...");
    }
}

class PaperKite extends Kite {
    @Override
    public void stop() {
        System.out.println("...PaperKite stop...");
    }

    @Override
    public void attack() {
        System.out.println("...PaperKite attrack...");
    }
}

/**
 * 接口与接口之间可以多继承
 */
interface  A {
    void mth1();
}

interface B {
    void mth2();
}
interface C extends A, B {

}
package com.allst.jcore.basic;

/**
 * 记住：这个是聪明反被聪明误的题目
 * 多态机制遵循的原则概括为：
 * 当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，
 * 但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法，
 * 但是它仍然要根据继承链中方法调用的优先级来确认方法，该
 * 优先级为：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
 * @author June 2019/02/18 下午 11:18
 * @version 1.0
 */
public class Sub extends Fat {
    public static void main(String[] args) {
        Fat fat = new Fat();
        Sub sub = new Sub();
        System.out.println(fat.getLength().toString() + " , " + sub.getLength().toString());
    }

    @Override
    public Integer getLength() {
        return new Integer(5);
    }
}
class Fat {
    public Integer getLength() {
        return new Integer(4);
    }
}
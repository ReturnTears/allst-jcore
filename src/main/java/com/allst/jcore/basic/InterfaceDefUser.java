package com.allst.jcore.basic;

import com.allst.jcore.entity.User;

/**
 * 接口：
 * 1、接口中不能定义构造器
 * 2、方法全部都是抽象方法
 * 3、抽象类中的成员可以是 public、protected、默认、private
 * 4、接口中定义的成员变量实际上都是常量
 * 5、接口中不能有静态方法
 * 6、一个类可以实现多个接口
 * @author June 2019/02/18 下午 11:56
 * @version 1.0
 */
public interface InterfaceDefUser {
    /**
     * 接口中定义的成员变量
     */
    String name = "Xiao";
    Integer age = 22;


    /**
     * del user 抽象方法
     */
    void doUser(User user);

}

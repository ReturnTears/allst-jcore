package com.allst.jcore.basic;

/**
 * 抽象类：
 * 1、抽象类可以有构造器
 * 2、可以有抽象方法和具体方法
 * 3、接口中的成员全都是public的 (jdk8+的访问修饰符public可以不写，默认就是public)
 * 4、抽象类中可以定义成员变量
 * 5、有抽象方法的类必须被声明为抽象类，而抽象类未必要有抽象方法
 * 6、抽象类中可以包含静态方法
 * 7、一个类只能继承一个抽象类
 * @author June 2019/02/15 上午 11:48
 * @version 1.0
 */
public abstract class AbstractUser {

    /**
     * 成员变量
     */
    public String username;
    public String password;

    public AbstractUser() {
    }

    public AbstractUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Put User method 抽象方法
     */
    public abstract void putUser();

    /**
     * 抽象类中可以包含静态方法
     */
    private static void addUser(){
        System.out.println("AbstractUser `s addUser methods......");
    }

    /**
     * Get User info 具体方法
     */
    public void getUser() {
        System.out.println("AbstractUser `s getUser methods......");
    }
}

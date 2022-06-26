package com.allst.jcore.anno;

import java.util.ArrayList;
import java.util.List;

/**
 * Java内置注解测试类2
 * Java 1.5开始自带的标准注解，包括@Override、@Deprecated和@SuppressWarnings
 * // @Override：表示当前的方法定义将覆盖父类中的方法
 * // @Deprecated：表示代码被弃用，如果使用了被@Deprecated注解的代码则编译器将发出警告
 * // @SuppressWarnings：表示关闭编译器警告信息
 *
 * @author June
 * @since 2022-06-26
 */
public class DemoClassB extends DemoClassA {
    /**
     * 重写父类的test方法
     */
    @Override
    public void test() {
    }

    /**
     * 被弃用的方法
     */
    @Deprecated
    public void oldMethod() {
    }

    /**
     * 忽略告警
     */
    @SuppressWarnings("rawtypes")
    public List processList() {
        List list = new ArrayList();
        System.out.println("come in method processList。。。");
        return list;
    }
}

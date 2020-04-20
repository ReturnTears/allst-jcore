package com.allst.jcore.basic;

/**
 * 模板方法的设计模式
 * @author YiYa
 * @since 2020-04-20 下午 10:31
 */
public class TemplateMethod {
    public static void main(String[] args) {
        SubTemplate subTemplate = new SubTemplate();
        subTemplate.speedTime();
    }
}

abstract class Template {
    public void speedTime() {
        long start = System.currentTimeMillis();
        this.code();
        long end = System.currentTimeMillis();
        System.out.printf("耗时: %d", end - start);
    }
    public abstract void code();
}

class SubTemplate extends Template {
    @Override
    public void code() {
        for (int i = 2; i <= 100 ; i++) {
            boolean isFlag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}
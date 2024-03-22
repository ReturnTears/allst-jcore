package com.allst.jcore.jv8;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * Java8函数式编程:Lambda表达式
 * @author June 2018-02-18
 * @version 1.0
 */
public class AllstJv8Lambda {
    public static void main(String[] args) {
        /**
         * Lambda表达式1
         * Lambda 表达式不包含参数，使用空括号() 表示没有参数。该Lambda 表达式
         * 实现了Runnable 接口，该接口也只有一个run 方法，没有参数，且返回类型为void。
         */
        Runnable noArg = () -> System.err.println("Hello Lambda.");
        noArg.run();

        /**
         * Lambda 表达式的主体不仅可以是一个表达式，而且也可以是一段代码块，
         * 使用大括号（{}）将代码块括起来
         */
        ActionListener oneArg = event -> System.out.println("button clicked.");

        /**
         * 代码块和普通方法遵循的规则别无二致，可以用返回或抛出异常来退出。
         * 只有一行代码的Lambda 表达式也可使用大括号，用以明确Lambda表达式从何处开始、到哪里结束。
         */
        Runnable multiArg = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };
        multiArg.run();

        //System.out.println(noArg);

        JavaEightLambda noArgs = (msg) -> System.out.println(msg);
        noArgs.printLambda("yangyang");

        JavaEightMulti mutliArg = (x, y) -> x + y;
        System.out.println(mutliArg.printMulti(1, 2));

        BinaryOperator<Long> add = Long::sum;
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
        System.out.println(add.apply(1L, 2L));
        Long apply = addExplicit.apply(2L, 3L);
        System.out.println(apply);
    }

    interface JavaEightLambda {
        /**
         * lambda表达式测试
         * @param msg 参数1
         */
        void printLambda(String msg);
    }

    interface JavaEightMulti {
        /**
         * 打印多个参数
         * @param x 参数1
         * @param y 参数2
         * @return int
         */
        int printMulti(int x, int y);
    }
}

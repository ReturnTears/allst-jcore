package com.allst.jcore.jv8.lambda0;

import com.allst.jcore.jv8.basic.Apple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * lambda表达式
 *
 * @author YiYa
 * @since 2020-03-24 下午 10:44
 */
public class LambdaExpression {

    public static void main(String[] args) {

        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();

        list.sort(byColor);

        Comparator<Apple> byColor2 = (o1, o2) -> o1.getColor().compareTo(o2.getColor());

        // System.out.println(list);

        Function<String, Integer> flambda = s -> s.length();
        // System.out.println(flambda);


    }

}

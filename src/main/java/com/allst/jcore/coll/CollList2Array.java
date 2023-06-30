package com.allst.jcore.coll;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 集合转数组
 *
 * @author Hutu
 * @since 2023-06-30 下午 04:59
 */
public class CollList2Array {
    public static void main(String[] args) {
        String[] s = new String[]{"dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"};
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        //没有指定类型的话会报错
        s = list.toArray(new String[0]);
        System.out.println(Arrays.toString(s));
    }
}

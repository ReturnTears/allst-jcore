package com.allst.jcore.coll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数组转集合
 * 使用 Java8 的 Stream(推荐)
 *
 * @author Hutu
 * @since 2023-06-30 下午 05:05
 */
public class CollArray2List {
    public static void main(String[] args) {
        Integer[] myArray = {1, 2, 3};
        List<Integer> myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList);

        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int[] myArray2 = {1, 2, 3};
        List<Integer> myList2 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        System.out.println(myList2);
    }
}

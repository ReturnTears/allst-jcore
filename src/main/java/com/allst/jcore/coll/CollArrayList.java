package com.allst.jcore.coll;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author June
 * @since 2022-07-05
 */
public class CollArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("Java");
        list.add(1, "Scala"); // 指定位置添加元素
        list.set(0, "Go");  // 指定位置替换元素，返回旧元素
        System.out.println(list.size());
        list.forEach(System.out::println);
        List<String> lists = Lists.newArrayList();
    }
}

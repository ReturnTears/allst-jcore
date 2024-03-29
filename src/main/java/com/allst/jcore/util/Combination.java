package com.allst.jcore.util;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Hutu
 * @since 2023-03-10 下午 11:34
 */
public class Combination {
    // elements为要操作的数据集合，即长度为M的容器，num为每次取的元素个数
    public static List<List<String>> combiner(List<String> elements, int num, List<List<String>> result) {
        //当num为1时，即返回结果集
        if (num == 1) {
            return result;
        }
        //result的长度是变化的，故把原始值赋给变量leng
        int leng = result.size();
        //循环遍历，将 elements每两个元素放到一起，作为result中的一个元素
        for (int i = 0; i < leng; i++) {
            for (String element : elements) {
                if (!result.get(i).contains(element)) {
                    List<String> list1 = new ArrayList<>(result.get(i));
                    list1.add(element);
                    Collections.sort(list1);
                    result.add(list1);
                }
            }
        }
        //将result中的循环遍历前的数据删除
        if (leng > 0) {
            result.subList(0, leng).clear();
        }
        //对result进行去重
        Iterator<List<String>> it = result.iterator();
        List<List<String>> listTemp = new ArrayList<>();
        while (it.hasNext()) {
            List<String> a = it.next();
            if (listTemp.contains(a)) {
                it.remove();
            } else {
                listTemp.add(a);
            }
        }
        //递归计算，根据num的值来确定递归次数
        combiner(elements, num - 1, result);
        return result;
    }

    //elements为要操作的数据集合，即长度为M的容器，num为每次取的元素个数
    public static List<List<String>> findSort(List<String> elements, int num) {
        List<List<String>> result = new ArrayList<>();
        //将elements中的数据取出来，存到新的list中，为后续计算做准备
        for (String element : elements) {
            List<String> list = new ArrayList<>();
            list.add(element);
            result.add(list);
        }
        return combiner(elements, num, result);
    }

    public static void Permutation(String[] s, int from, int to, Set<String> result) {
        if (to < 1)
            return;
        if (to == 1) {
            swap(s, 0, 1);
            //System.out.println(StringUtils.join(s, StrUtil.COMMA));
            result.add(StringUtils.join(s, StrUtil.COMMA));
        }
        if (from == to) {
            // System.out.println(StringUtils.join(s, StrUtil.COMMA));
            result.add(StringUtils.join(s, StrUtil.COMMA));
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from);
                Permutation(s, from + 1, to, result);
                swap(s, from, i);
            }
        }
    }

    public static void swap(String[] s, int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    // 验证
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f");
        System.out.println(list.contains("c"));
        // 从list中每次取三个元素
        List<List<String>> result = findSort(list, 2);
        List<String> collect = result.stream().map(x -> StrUtil.join(",", x)).collect(Collectors.toList());
        System.out.println("result : " + collect);
        /*for (List<String> strings : result) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }*/
        Set<String> sets = Sets.newHashSet();
        for (String s : collect) {
            // String[] param = { "a", "b", "c", "d", "e", "f" };
            String[] param = s.split(",");
            Permutation(param, 0, param.length - 1, sets);
        }
        ArrayList<String> arrayList = Lists.newArrayList(sets);
        System.out.println(sets);
        System.out.println(arrayList);
    }

}

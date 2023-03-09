package com.allst.jcore.basic;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Hutu
 * @since 2023-03-09 下午 08:34
 */
public class CalcNumber {
    public static void main(String[] args) {
        int[] data = {1, 3, 6, 7, 8, 9, 10, 13, 14, 15, 16, 19, 20};
        // calc(data);

        List<Integer> param = Lists.newArrayList(1, 3, 6, 7, 8, 9, 10, 13, 14, 15, 16, 19, 20);
        sort(param);
    }

    private static void cal(int[] data) {
        int size = data.length;
        int curr = 0;
        int next = 0;
        Set<Integer> list = Sets.newHashSet();
        for (int i = 0; i < size; i++) {
            curr = data[i];
            if (i == 0) {
                list.add(curr);// 第一个元素
            }
            if ((i + 1) == size) {
                list.add(data[i]);// 最后一个元素
                break;
            }
            next = data[i + 1];
            if (Math.abs((curr - next)) == 1) {
                curr = next;
            } else {
                System.out.println(curr + "--" + next);//前一段段尾，后一段段头
                list.add(curr);
                list.add(next);
            }
        }
        // 每2个作为1段
        int total = list.size();
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static String sort(List<Integer> arr) {
        if (arr == null || arr.size() == 0) return "";
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < arr.size() - 1) {
            int j = i;
            int k = i + 1;
            while (j < arr.size() - 1 && k < arr.size() && arr.get(j) + 1 == arr.get(k)) {
                j++;
                k++;
            }
            if (j - i <= 0) {
                sb.append(arr.get(i)).append(",");
            } else {
                sb.append(arr.get(i)).append("~").append(arr.get(j)).append(",");
            }
            i = k;
        }

        String str = sb.substring(0, sb.length() - 1);
        // System.out.println("str = " + str);
        return str;
    }

    private static void calc(int[] data) {
        int size = data.length;
        int prev = 0, curr = 0, next = 0;
        List<Integer> list = Lists.newArrayList();
        List<String> result = Lists.newArrayList();
        // 1, 3, 6, 7, 8, 9, 10, 13, 14, 15, 16, 19, 20
        for (int i = 0; i < size; i++) {
            curr = data[i];
            if (i == 0) {
                prev = curr;
                list.add(curr);
            }
            if ((i + 1) == size) {
                break;
            }
            next = data[i + 1];
            if (Math.abs((curr - next)) != 1) {
                list.add(curr);
                result.add(String.format("%s~%s", prev, next));
                list.add(next);
            } else {
                prev = next;
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        for (String s : result) {
            System.out.print(s + " , ");
        }
    }

}

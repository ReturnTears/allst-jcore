package com.allst.jcore.basic;

import com.allst.jcore.entity.User;

import java.util.*;

/**
 * HashMap集合排序
 * 已知一个HashMap<Integer, User>集合，User有name（String）和age（int）属性。
 * 写一个方法实现对HashMap的排序功能，该方法接收HashMap<Integer, User>为形参，
 * 返回类型为HashMap<Integer, User>,要求对HashMap中的User的age倒序排序，排序时key=value键值对不能拆散
 * @author June 2019/02/19 下午 01:51
 * @version 1.0
 */
public class HashMapCollectSort {

    public static void main(String[] args) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        hashMap.put(1, new User("yangyang", 18));
        hashMap.put(3, new User("xiaohu", 23));
        hashMap.put(4, new User("kangkang", 22));
        hashMap.put(2, new User("lisi", 21));
        HashMap<Integer, User> sortHashMap = sortHashMap(hashMap);
        System.out.println(sortHashMap);
    }

    private static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        // 1、获取map的键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();
        // 2、将Set集合转换为List集合,为了使用工具类的排序方法
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);
        // 3、使用Collections集合工具类对list进行排序
        Collections.sort(list, (o1, o2) -> o2.getValue().getAge() - o1.getValue().getAge());
        // 4、创建一个新的有序的HashMap子类的集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
//        TreeMap<Integer, User> treeMap = new TreeMap<>();
        // 5、将List中的数据存储在LinkedHashMap中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
//            treeMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

}

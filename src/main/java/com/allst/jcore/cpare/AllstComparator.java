package com.allst.jcore.cpare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator:对于比较对象间的不同属性，Comparator能更好的胜任
 * comparable:内部比较，comparator：外部比较。
 * @author June 2018-01-13 下午 08:55
 * @version 1.0
 */
public class AllstComparator {
    public static void main(String[] args) {
        CpareEntity entity1 = new CpareEntity(3, "Do");
        CpareEntity entity2 = new CpareEntity(8, "Know ?");
        CpareEntity entity3 = new CpareEntity(6, "You");
        List<CpareEntity> list = new ArrayList<>();
        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        Collections.sort(list, new ComparatorEntity());
        System.out.println("排序后的结果: ");
        for (CpareEntity c : list) {
            System.out.print(c.getInfo() + " ");
        }
    }

    /**
     * 自定义比较器
     */
    private static class ComparatorEntity implements Comparator<CpareEntity> {
        @Override
        public int compare(CpareEntity cp1, CpareEntity cp2) {
            int i = cp1.getSize();
            int j = cp2.getSize();
            if (i > j) {
                return 1;
            } else if (i < j) {
                return  -1;
            } else {
                return 0;
            }
        }
    }
}

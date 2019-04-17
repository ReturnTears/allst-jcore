package com.allst.jcore.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 循环遍历list集合中元素的过程中删除其中的元素常见问题
 * @author June 2019/02/21 下午 09:31
 * @version 1.0
 */
public class RemoveListByFor {
    public static void main(String[] args) {
        removeListByFor();
    }

    /**
     * for循环遍历List集合并删除其中的元素(这种方式只适合删除一个特定元素时使用，不适合循环删除多个元素)
     * 运行结果为:
     *      只删除了下标奇数位的元素
     *   出现问题的原因在于:删除某个元素后，list的大小发生了变化，而你的索引也在变化，所以会导致你在遍历的时候漏掉某些元素
     */
    private static void removeListByFor() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(9);
        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals(1)) {
                System.out.println(list);
                System.out.println(list.get(i));
                list.remove(list.get(i));
//            }
        }
        System.out.println(list);
    }

    /**
     * foreach循环删除List集合中的元素:
     *      这种方式的问题在于，删除元素后继续循环会报错误信息ConcurrentModificationException，
     *      因为元素在使用的时候发生了并发的修改，导致异常抛出。但是删除完毕马上使用break跳出，则不会触发报错。
     */
    private static void removeListByForeach() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(9);
        for (Integer i : list) {
//            if (i.equals(3)) {
                System.out.println(i);
                System.out.println(list.remove(i));
                break;
//            }
        }
        System.out.println(list);
    }

    /**
     * iterator循环删除List集合中的元素:
     * 这种方式可以正常的循环及删除。但要注意的是，使用iterator的remove方法，如果用list的remove方法同样会报上面提到的ConcurrentModificationException错误。
     */
    private static void removeListByIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(9);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(list);
    }
}

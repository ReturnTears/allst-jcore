package com.allst.jcore.cpare;

/**
 * Comparable与Comparator的比较
 * 一个类实现Comparable接口，是为了可以让其自身的对象和其他对象进行比较。
 * 类本身必须实现这个接口，为的是可以和它自己的实例进行比较。要求实现的方法是compareTo()
 * @author June 2019-01-13 下午 09:24
 * @version 1.0
 */
public class AllstComparable implements Comparable<AllstComparable> {

    private int size;
    private String info;

    public int getSize() {
        return size;
    }

    public String getInfo() {
        return info;
    }

    public AllstComparable(int size, String info) {
        this.size = size;
        this.info = info;
    }

    @Override
    public int compareTo(AllstComparable o) {
        if (this.getSize() > o.getSize()) {
            return 1;
        } else if (this.getSize() < o.getSize()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        AllstComparable entity1 = new AllstComparable(101, "Hello World!");
        AllstComparable entity2 = new AllstComparable(202, "Hi JavaScript");
        if (entity1.compareTo(entity2) > 0) {
            System.out.println(entity1.getInfo());
        } else {
            System.out.println(entity2.getInfo());
        }
    }
}

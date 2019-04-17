package com.allst.jcore.cpare;

/**
 * Comparator 和 Comparable 的公共实体类
 * @author June 2019-01-13 下午 08:53
 * @version 1.0
 */
public class CpareEntity {
    private int size;
    private String info;

    public CpareEntity(int size, String info) {
        this.size = size;
        this.info = info;
    }

    public int getSize() {
        return size;
    }

    public String getInfo() {
        return info;
    }
}

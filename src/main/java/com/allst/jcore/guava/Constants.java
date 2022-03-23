package com.allst.jcore.guava;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据源
 *
 * @author June
 * @since 2022-03-23
 */
public final class Constants {
    public static Map<String, String> hm = new HashMap<>();
    static {
        hm.put("1", "Java");
        hm.put("2", "JavaScript");
        hm.put("3", "Scala");
        hm.put("4", "Go");
        hm.put("5", "Python");
        hm.put("6", "C++");
    }
}

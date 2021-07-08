package com.allst.jcore.vavr;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Stream;
import org.junit.Assert;

import java.util.Optional;

/**
 * Vavr To Java Conversion
 *
 * @author June
 * @since 2021年07月
 */
public class VavrToJava {
    public static void main(String[] args) {
        /*
         * 从 Vavr的List或Stream中获取Java List
         */
        List<String> vavrStringList = List.of("JAVA", "Javascript", "Scala", "Go");
        System.out.println(vavrStringList);
        java.util.List<String> javaStringList = vavrStringList.toJavaList();
        System.out.println(javaStringList);

        Stream<String> vavrStream = Stream.of("JAVA", "Javascript", "Scala");
        java.util.List<String> javaStringList2 = vavrStream.toJavaList();
        System.out.println(javaStringList2);

        /*
         * 从 Vavr 对象中获取其他 Java 集合
         */
        Map<String, String> vavrMap = HashMap.of("1", "a", "2", "b", "3", "c");
        java.util.Map<String, String> javaMap = vavrMap.toJavaMap();
        System.out.println(javaMap); // {1=a, 2=b, 3=c}

        /*
         * 使用toJavaOptional()方法获取Optional
         */
        List<String> vavrList = List.of("Java");
        Optional<String> optional = vavrList.toJavaOptional();
        // java断言失败， 抛出异常
        // Assert.assertEquals("java", optional.get());
        Assert.assertEquals("Java", optional.get());

        System.out.println("Hello Vavr");

        /*
         * other:
         * toJavaArray()
         * toJavaCollection()
         * toJavaList()
         * toJavaMap()
         * toJavaSet()
         * toJavaOptional()
         * toJavaParallelStream()
         * toJavaStream()
         */
    }
}

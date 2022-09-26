package com.allst.jcore.vavr;

import io.vavr.collection.LinkedHashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.collection.Stream;
import org.junit.Assert;

import java.util.Arrays;

/**
 * Java To Vavr Conversion
 * Vavr 中的所有集合实现都有一个基本类型Traversable。 因此，每个集合类型都有一个静态方法ofAll()，它接受一个Iterable并将其转换为相应的Vavr集合
 * Vavr 库还提供Java集合视图，这些视图将调用委托给底层Vavr集合。
 * Vavr 到Java的转换方法通过迭代所有元素来构建一个Java集合来创建一个新实例。这意味着转换的性能是线性的，而创建集合视图的性能是恒定的。
 *
 * @author June
 * @since 2021年07月
 */
public class JavaToVavr {
    public static void main(String... args) {
        // java.util.List 转换为 Vavr List
        java.util.List<String> javaList = Arrays.asList("Java", "Haskell", "Scala");
        List<String> vavrList = List.ofAll(javaList);
        System.out.println(javaList);
        System.out.println(vavrList);

        // java.util.stream 转换为 Vavr stream
        java.util.stream.Stream<String> javaStream = Arrays.asList("Java", "Haskell", "Scala").stream();
        Stream<String> vavrStream = Stream.ofAll(javaStream);
        System.out.println(vavrStream.toList());

        // 对于 List，有两种方法可用于获取我们的视图。第一个是 asJava() ，它返回一个不可变列表 ，下一个是 asJavaMutable()。
        // 由于List是不可变的，因此对其执行任何修改都会引发UnsupportedOperationException。
        java.util.List<String> javaList2 = List.of("Java", "Haskell", "Scala").asJavaMutable();
        javaList2.add("Go");
        Assert.assertEquals(4, javaList2.size());

        // Vavr 对象之间的转换
        List<String> vavrList2 = List.of("Java", "Haskell", "Scala", "Java");
        Set<String> linkedSet = vavrList2.toLinkedSet();
        Assert.assertEquals(3, linkedSet.size());
        Assert.assertTrue(linkedSet instanceof LinkedHashSet);
    }
}

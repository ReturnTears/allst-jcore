package com.allst.jcore.guava;

import com.google.common.base.Joiner;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Joiner
 *
 * @author June
 * @since 2021年07月
 */
public class JoinerUtils {

    private final List<String> listStr = Arrays.asList("Google", "Guava", "Java", "JavaScript", "Kafka");
    private final List<String> listStrHasNull = Arrays.asList("Go", "JavaScript", "Java", "Scala", null);

    public static void main(String[] args) {
        JoinerUtils util = new JoinerUtils();
        util.joinerOnJoin();
        util.joinerOnSkipNullsJoin();
        util.joinerByStreamSkipNull();
        util.joinerOnUseForNullJoin();
        util.joinerByStreamForUseDefault();
        util.joinerOnUseForNullAppendTo();
    }

    public void joinerOnJoin() {
        String result = Joiner.on("#").join(listStr);
        Assert.assertEquals(result, "Google#Guava#Java#JavaScript#Kafka");
    }

    public void joinerOnSkipNullsJoin() {
        String result = Joiner.on("#").skipNulls().join(listStrHasNull);
        Assert.assertEquals(result, "Go#JavaScript#Java#Scala");
    }

    public void joinerByStreamSkipNull() {
        String result = listStrHasNull.stream().filter(item -> item != null && !item.isEmpty()).collect(joining("#"));
        Assert.assertEquals(result, "Go#JavaScript#Java#Scala");
    }

    public void joinerOnUseForNullJoin() {
        String result = Joiner.on("#").useForNull("Default").join(listStrHasNull);
        Assert.assertEquals(result, "Go#JavaScript#Java#Scala#Default");
    }

    public void joinerByStreamForUseDefault() {
        String result = listStrHasNull.stream().map(item -> item == null || item.isEmpty() ? "Default" : item).collect(joining("#"));
        Assert.assertEquals(result, "Go#JavaScript#Java#Scala#Default");
    }

    public void joinerOnUseForNullAppendTo() {
        final StringBuilder builder = new StringBuilder();
        StringBuilder stringBuilder = Joiner.on("#").useForNull("Default").appendTo(builder, listStrHasNull);
        Assert.assertEquals(stringBuilder.toString(), "Go#JavaScript#Java#Scala#Default");
        Assert.assertEquals(builder.toString(), "Go#JavaScript#Java#Scala#Default");
    }
}

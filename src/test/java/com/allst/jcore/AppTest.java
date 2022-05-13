package com.allst.jcore;

import org.junit.Test;

import static com.allst.jcore.basic.CommUtils.func1;
import static com.allst.jcore.basic.CommUtils.func2;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test1() {
        System.out.println(func1("JAVA"));
    }

    @Test
    public void test2() {
        System.out.println(func2("JAVA"));
    }
}

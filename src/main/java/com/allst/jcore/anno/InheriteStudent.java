package com.allst.jcore.anno;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @author June
 * @since 2022-06-26
 */
public class InheriteStudent extends InheritePerson {
    @Test
    public void test() {
        Class clazz = InheritePerson.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            // 输出 @com.allst.jcore.anno.TestInheritedAnnotation(values={"value"}, number=10)
            System.out.println(annotation.toString());
        }
    }
}

package com.allst.jcore.anno;

import java.lang.annotation.*;

/**
 * @author June
 * @since 2022-06-26
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface TestInheritedAnnotation {
    String [] values();
    int number();
}

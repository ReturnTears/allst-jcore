package com.allst.jcore.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 以下代码在使用Javadoc工具可以生成@TestDocAnnotation注解信息。
 *
 * @author June
 * @since 2022-06-26
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface TestDocAnnotation {
    String value() default "default";
}

package com.allst.jcore.anno;

import java.util.ArrayList;

/**
 * 测试类
 *
 * @author June
 * @since 2022-06-27
 */
public class TestTypeParameterAndTypeUseAnnotation<@MyNotEmpty T> {
   public @MyNotNull T test(@MyNotNull T t) {
       // Lists.newArrayList<@MyNotNull String>();
       new ArrayList<@MyNotNull String>();
       return t;
   }
}

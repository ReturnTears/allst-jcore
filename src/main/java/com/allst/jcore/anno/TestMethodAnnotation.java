package com.allst.jcore.anno;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author June
 * @since 2022-06-27
 */
public class TestMethodAnnotation {

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List list = new ArrayList();
        list.add("abc");
        oldMethod();
    }

    /**
     * 输出结果：
     * Annotation in Method 'public java.lang.String com.allst.jcore.anno.TestMethodAnnotation.toString()' : @com.allst.jcore.anno.MyMethodAnnotation(title="toStringMethod", description="override toString method")
     * toStringMethod
     * Annotation in Method 'public static void com.allst.jcore.anno.TestMethodAnnotation.oldMethod()' : @java.lang.Deprecated(forRemoval=false, since="")
     * Annotation in Method 'public static void com.allst.jcore.anno.TestMethodAnnotation.oldMethod()' : @com.allst.jcore.anno.MyMethodAnnotation(title="old static method", description="deprecated old static method")
     * old static method
     * Annotation in Method 'public static void com.allst.jcore.anno.TestMethodAnnotation.genericsTest() throws java.io.FileNotFoundException' : @com.allst.jcore.anno.MyMethodAnnotation(title="test method", description="suppress warning static method")
     * test method
     */
    public static void main(String[] args) {
        try {
            // 获取所有methods
            Method[] methods = TestMethodAnnotation.class.getClassLoader().loadClass("com.allst.jcore.anno.TestMethodAnnotation").getMethods();
            // 遍历
            for (Method method : methods) {
                // 方法上是否有MyMethodAnnotation注解
                if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                    try {
                        // 获取并遍历方法上的所有注解
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + anno);
                        }
                        // 获取MyMethodAnnotation对象信息
                        MyMethodAnnotation methodAnno = method.getAnnotation(MyMethodAnnotation.class);
                        System.out.println(methodAnno.title());
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Override toString method";
    }

}

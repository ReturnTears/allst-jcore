package com.allst.jcore.anno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class类的创建方式
 * @author YiYa
 * @since 2020-09-28 下午 11:00
 */
public class AnnoPratice {
    public static void main(String[] args) throws ClassNotFoundException {
        Work teacher = new Teacher();
        System.out.println(teacher.name + " is a work!");

        // 方式1-通过对象获得
        Class<? extends Work> c1 = teacher.getClass();
        System.out.println(c1.hashCode());

        // 方式2-forName获得
        Class<?> c2 = Class.forName("com.allst.jcore.anno.Teacher");
        System.out.println(c2.hashCode());

        // 方式3-通过类名获得
        Class<Teacher> c3 = Teacher.class;
        System.out.println(c3.hashCode());

        // 方式4-基于内置类型的包装类都有一个Type属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);

        // 方式5-获取父类类型
        Class<?> c5 = c1.getSuperclass();
        System.out.println(c5);

        /**
         * 获取类的信息
         */
        Class<?> forName = Class.forName("com.allst.jcore.entity.User");
        System.out.println(forName.getName());// 包名+类名
        System.out.println(forName.getSimpleName());// 类名
        Field[] fields = forName.getFields();   // 只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] fields2 = forName.getDeclaredFields(); // 找到全部的属性
        for (Field field : fields2) {
            System.out.println(field);
        }

        try {
            // 获取指定属性
            Field name = forName.getDeclaredField("name");
            System.out.println(name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        // 获得本类及其父类的全部public方法
        Method[] methods = forName.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 获得本类的所有方法
        Method[] declaredMethods = forName.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        // 获取指定方法
        try {
            Method getName = forName.getMethod("getName", null);
            Method setAge = forName.getMethod("setAge", int.class);
            System.out.println(getName);
            System.out.println(setAge);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 获取构造器
        Constructor<?>[] constructors = forName.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}

class Work {
    public String name;

    public Work() {

    }

    public Work(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Work{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Teacher extends Work {
    public Teacher() {
        this.name = "老师";
    }
}

class Doctor extends Work {
    public Doctor() {
        this.name = "医生";
    }
}
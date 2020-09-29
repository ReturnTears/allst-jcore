package com.allst.jcore.anno;

import com.allst.jcore.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class类的创建方式
 * @author YiYa
 * @since 2020-09-28 下午 11:00
 */
public class AnnoPratice {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
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

        // 构造一个对象：本质上调用了类的午餐构造器，如果没有显示申明的无参构造器，运行则会报错
        User user = (User) forName.newInstance();
        System.out.println(user);

        // 通过构造器创建对象, 不用显示申明无参构造器也可以, 把无参构造注释后测试
        try {
            Constructor<?> declaredConstructor = forName.getDeclaredConstructor(String.class, int.class);
            User user1 = (User) declaredConstructor.newInstance("Wahaha", 18);
            System.out.println(user1);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 通过反射调用普通方法
        User user2 = (User) forName.newInstance();
        try {
            // 通过反射获取一个方法
            Method setName = forName.getDeclaredMethod("setName", String.class);
            // 激活执行
            setName.invoke(user2, "ZhangSan");
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user2.getName());

        // 通过反射操作属性， 操作属性不能直接操作私有属性
        User user3 = (User) forName.newInstance();
        try {
            Field name = forName.getDeclaredField("name");
            name.setAccessible(true); // 关闭安全检测
            name.set(user3, "Lisi");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(user3.getName());
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
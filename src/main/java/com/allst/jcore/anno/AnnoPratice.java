package com.allst.jcore.anno;

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
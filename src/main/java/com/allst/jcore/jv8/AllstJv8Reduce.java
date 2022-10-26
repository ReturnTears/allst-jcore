package com.allst.jcore.jv8;

import com.allst.jcore.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hutu
 * @since 2022-10-26 下午 10:08
 */
public class AllstJv8Reduce {
    public static void main(String[] args) {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 2000, 18));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 2371, 55));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 3322, 25));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 35020, 15));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 2272, 25));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 2057, 87));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 3120, 99));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 345, 25));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 3375, 14));
                add(new Person("Addison", "Pam", "Java programmer", "female", 3426, 20));
            }
        };

        int reduce = javaProgrammers.stream().mapToInt(Person::getSalary).reduce(10000, (x, y) -> x = x + y);
        System.out.println("reduce:" + reduce);

        String reduce1 = javaProgrammers.stream().map(Person::getFirstName).reduce("", (x, y) -> x + String.format("'%s',", y));
        reduce1 = reduce1.substring(0, reduce1.length() - 1);
        System.out.println(reduce1);
    }
}

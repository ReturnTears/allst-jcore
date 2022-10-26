package com.allst.jcore.entity;

/**
 * @author Hutu
 * @since 2022-10-26 下午 10:09
 */
public class Person {
    private String firstName;
    private String lastName;
    private String language;
    private String sex;
    private Integer salary;
    private Integer age;

    public Person(String firstName, String lastName, String language, String sex, Integer salary, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.sex = sex;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

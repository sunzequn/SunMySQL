package com.sunzequn.sunmysql.test.annotations;

import com.sunzequn.sunmysql.annotations.Column;
import com.sunzequn.sunmysql.annotations.Table;

/**
 * Created by Sloriac on 15/11/18.
 */
@Table(name = "person")
public class Person {

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

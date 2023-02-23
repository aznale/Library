package org.example;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

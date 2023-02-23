package org.example;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String surname;
    private int age;
    private String address;


    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }
}

package org.example;

import com.github.javafaker.Faker;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {


    Faker faker = new Faker();
    private Person person = new Person("Joan", "Serra", 35, "C/Carrer num pis porta");

    @Test
    public void getPerson(){

        assertAll("person",
                ()-> assertEquals("Joan", person.getName()),
                ()-> assertEquals("Serra",person.getSurname()),
                ()-> assertEquals(35,person.getAge()),
                ()-> assertEquals("C/Carrer num pis porta", person.getAddress())
                );

        System.out.println(person);
    }

    @Test
    public void setPerson(){

        System.out.println(person);

        person.setName("Lluís");
        person.setSurname("Pis");
        person.setAge(20);
        person.setAddress("C/Carrer diferent");

        assertAll("person",
                ()-> assertEquals("Lluís", person.getName()),
                ()-> assertEquals("Pis",person.getSurname()),
                ()-> assertEquals(20,person.getAge()),
                ()-> assertEquals("C/Carrer diferent", person.getAddress())
        );

        System.out.println(person);

    }


}

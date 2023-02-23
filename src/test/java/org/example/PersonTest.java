package org.example;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    Person person = new Person("Joan", 45);
    @Test
    public void getPerson(){
        String name = this.person.getName();
        Assertions.assertEquals("Joan", name);
    }


}

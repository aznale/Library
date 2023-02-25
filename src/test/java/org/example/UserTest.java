package org.example;

import org.example.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private final User user = new User("Pere","Pintorpastera",28,"C/De Dalt","01684");

    @Test
    public void getUser(){
        assertAll("person",
                ()-> assertEquals("Pere", user.getName()),
                ()-> assertEquals("Pintorpastera",user.getSurname()),
                ()-> assertEquals(28,user.getAge()),
                ()-> assertEquals("C/De Dalt", user.getAddress()),
                ()-> assertEquals("01684",user.getIdMember())
        );

        System.out.println(user);
    }

/*    @Test
    public void setUser(){
        System.out.println(user);

        user.setName("Lluís");
        user.setSurname("Pis");
        user.setAge(20);
        user.setAddress("C/Carrer diferent");
        user.setIdMember("01500");

        assertAll("person",
                ()-> assertEquals("Lluís", user.getName()),
                ()-> assertEquals("Pis",user.getSurname()),
                ()-> assertEquals(20,user.getAge()),
                ()-> assertEquals("C/Carrer diferent", user.getAddress()),
                ()-> assertEquals("01500",user.getIdMember())
        );

        System.out.println(user);
    }*/
}

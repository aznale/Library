package org.example.controller;

import com.github.javafaker.Faker;
import org.example.manager.BookManager;
import org.example.model.Book;
import org.example.utils.DataValues;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    /*@GetMapping("/helloRest/{user}")
    public String helloWorld(@PathVariable String user){
        return "Welcome to the jungle " + user + "!!";
    }

    @GetMapping("/sumar/{numA}/{numB}")
    public int sumar(@PathVariable int numA,@PathVariable int numB){
        return numA + numB;
    }*/

    public static Map<String, User> users = new HashMap<>();

    public static void createUsers(int usersNumber) {
        Faker faker = new Faker();
        User newUser;
        int sumNewMaxId = DataValues.getIdNumber();

        for (int i = 0; i < usersNumber; i++) {
            newUser = new User(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.random().nextInt(18, 99),
                    faker.address().fullAddress(),
                    ""
            );

            newUser.setIdMember(String.format("%04d",sumNewMaxId));
            sumNewMaxId++;

            users.put(newUser.getIdMember(), newUser);
            System.out.println(newUser);

        }

        DataValues.setIdNumber(sumNewMaxId);
    }



    @GetMapping("/users")
    public Map<String, User> listingAllUsers(){
        if(users.isEmpty()){
            createUsers(10);
        }
        return users;
    }

    @GetMapping("/users/{getUser}")
    public User getUser(@PathVariable String getUser){
        for (Map.Entry<String,User> user: users.entrySet()) {
            if(user.getValue().getName().equalsIgnoreCase(getUser)){
                return user.getValue();
            }
        }
        return null;
    }

    @DeleteMapping("/users/{deleteUser}")
    public void deleteUser(@PathVariable String deleteUser){
        for (Map.Entry<String,User> user: users.entrySet()) {
            if(user.getValue().getName().equalsIgnoreCase(deleteUser)){
                users.remove(user.getKey());
            }
        }
    }

    //https://www.youtube.com/watch?v=RfLx9RYjJA8&t=2005s




}

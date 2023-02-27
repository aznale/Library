package org.example.manager;

import com.github.javafaker.Faker;
import org.example.data.DataValues;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserManager {

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


}

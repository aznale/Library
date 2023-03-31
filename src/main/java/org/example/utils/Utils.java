package org.example.utils;

import com.github.javafaker.Faker;
import org.example.model.Book;
import org.example.model.User;

import java.util.Map;

public class Utils {

    public static void createBooks(Map<String, Book> bookToMap, int numberBooks) {
        Faker faker = new Faker();
        Book newBook;
        int sumNewMaxId = DataValues.getIdBook();

        for (int i = 0; i < numberBooks; i++) {
            String title = faker.book().title();
            newBook = new Book(
                    "",
                    faker.random().hex(12),
                    title,
                    String.valueOf(faker.random().nextInt(1440, 2023)),
                    faker.book().author(),
                    DataValues.getLanguage(faker.random().nextInt(0, DataValues.language.size() - 1)),
                    faker.book().publisher(),
                    faker.book().genre(),
                    true
            );

            newBook.setBookId(String.format("%07d", sumNewMaxId));
            sumNewMaxId++;

            bookToMap.put(newBook.getBookId(), newBook);
        }

        DataValues.setIdBook(sumNewMaxId);
    }

    public static void createUsers(Map<String, User> usersToMap, int usersNumber) {
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

            usersToMap.put(newUser.getIdMember(), newUser);
            //System.out.println(newUser);

        }

        DataValues.setIdNumber(sumNewMaxId);
    }

}

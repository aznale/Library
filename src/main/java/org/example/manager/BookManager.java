package org.example.manager;

import com.github.javafaker.Faker;
import org.example.model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookManager {

    public static Map<String, Book> books = new HashMap<>();

    public static void createBooks(int numberBooks) {
        Faker faker = new Faker();
        Book newBook;

        for (int i = 0; i < numberBooks; i++) {
            newBook = new Book(
                    String.valueOf(faker.random().nextInt(2000)),
                    faker.random().hex(12),
                    faker.book().title(),
                    String.valueOf(faker.random().nextInt(1440, 2023)),
                    faker.book().author(),
                    "wer",
                    "wer",
                    "ert",
                    true
            );
        }
    }
}

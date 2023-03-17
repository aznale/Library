package org.example.manager;

import com.github.javafaker.Faker;
import org.example.model.Book;
import org.example.utils.DataValues;

import java.util.Map;

public class BookManager {

    public static void createBooks(Map<String,Book> bookToMap, int numberBooks) {
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
}

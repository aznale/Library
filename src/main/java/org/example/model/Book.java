package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookId; // TODO append idLibrary? or *
    private String ISBN;
    private String title;
    private String yearPublication;
    private String author;
    private String language;
    private String publisher;
    private String matter;
    private boolean available; // For control individual borrow

    // TODO * add att.code of specific library to which the book belongs



    public void update(Book other) {
        Class<?> clazz = getClass();
        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(field -> {
                    try {
                        Object value = field.get(other);
                        return value != null &&
                                (!(value instanceof Number) || ((Number) value).intValue() != 0);
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                })
                .forEach(field -> {
                    try {
                        field.set(this, field.get(other));
                    } catch (IllegalAccessException e) {
                        // Handle exception
                    }
                });
    }

    @Override
    public String toString() {
        String borrowedMessage = "Available";
        if (!this.available) {
            borrowedMessage = "Borrowed";
        }

        return  "1 - Book Id: " + bookId + '\n' +
                "2 - ISBN: " + ISBN + '\n' +
                "3 - Title: " + title + '\n' +
                "4 - Year Publication: " + yearPublication + '\n' +
                "5 - Author: " + author + '\n' +
                "6 - Language: " + language + '\n' +
                "7 - Publisher: " + publisher + '\n' +
                "8 - Matter: " + matter + '\n' +
                "9 - Available: " + borrowedMessage +
                '\n';
    }
}

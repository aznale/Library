package org.example.manager;

import com.github.javafaker.Faker;
import org.example.utils.DataValues;
import org.example.model.Book;
import org.example.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookManager {

    public static Map<String, Book> books = new HashMap<>();

    public static void createBooks(int numberBooks) {
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

            books.put(title, newBook);
            System.out.println(newBook);
        }

        DataValues.setIdBook(sumNewMaxId);
    }

    public static void createBookToStorage(Scanner reader) {
        System.out.println("CREATE a NEW Book: \n");
        String bookId = String.valueOf(DataValues.getIdBook());
        String ISBN = Utils.askString(reader, "ISBN: ");
        String title = Utils.askString(reader, "Title: ");
        String yearPublication = Utils.askString(reader, "Year publication: ");
        String author = Utils.askString(reader, "Author: ");
        String language = Utils.askString(reader, "Language: ");
        String publisher = Utils.askString(reader, "Publisher: ");
        String matter = Utils.askString(reader, "Matter: ");
        boolean available = true;

        Book addNewBook = new Book(bookId, ISBN, title, yearPublication, author, language, publisher, matter, available);
        books.put(title, addNewBook);

        DataValues.setIdBook(Integer.parseInt(bookId) + 1); // Actualize idBook +1

        System.out.println("----- Book added successfully: -----" + addNewBook);
    }

    public static void deleteBook(Scanner reader) {
        System.out.println("DELETE Book: \n");
        String bookToDelete = Utils.askString(reader, "Book title to delete: ");
        books.remove(bookToDelete);
        System.out.println("----- Book deleted successfully: -----");

    }

    public static void updateBook(Scanner reader) {
        System.out.println("UPDATE Book: \n");
        String bookToUpdate = Utils.askString(reader, "Book to update: ");

        if (!bookToUpdate.isEmpty()) {
            System.out.println("Book found: \n" + books.get(bookToUpdate));
            while (true){
                String parameterToChange = Utils.askString(reader,"Parameter to change (e.g: author) or write exit: \n)");

                switch (parameterToChange){
                    case 1: parameterToChange = "bookId";

                }
            }



        } else {
            System.out.println(bookToUpdate + ": This book doesn't Exist");
        }
    }
}

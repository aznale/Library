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
        String bookToUpdate = Utils.askString(reader, "Book to update: \n");

        if (books.containsKey(bookToUpdate)) {
            System.out.println(books.get(bookToUpdate));

            while (true) {
                String parameterToChange = Utils.askString(reader, "\nEnter the parameter number to change or write exit: \n");


                switch (parameterToChange) {
                    case "exit" -> {
                        return;
                    }
                    case "1" -> System.out.println("Book Id is never change");
                    case "2" -> {
                        System.out.println("2 - ISBN: " + books.get(bookToUpdate).getISBN());
                        String setISBN = Utils.askString(reader, "Change to: ");
                        books.get(bookToUpdate).setISBN(setISBN);
                        System.out.println("Updated successfully.\n2 - ISBN: " + books.get(bookToUpdate).getISBN());
                    }
                    case "3" -> {
                        System.out.println("3 - Title: " + books.get(bookToUpdate).getTitle());
                        String setTitle = Utils.askString(reader, "Change to: ");
                        books.get(bookToUpdate).setTitle(setTitle);
                        System.out.println("Updated successfully.\n3 - Title: " + books.get(bookToUpdate).getTitle());
                    }
                    case "4" -> {
                        System.out.println("4 - Year Publication: " + books.get(bookToUpdate).getYearPublication());
                        String setYearPublication = Utils.askString(reader, "Change to: ");
                        books.get(bookToUpdate).setYearPublication(setYearPublication);
                        System.out.println("Updated successfully.\n4 - Year Publication: " + books.get(bookToUpdate).getYearPublication());
                    }
                    case "5" -> {
                        System.out.println("5 - Author: " + books.get(bookToUpdate).getAuthor());
                        String setAuthor = Utils.askString(reader, "Change to: ");
                        books.get(bookToUpdate).setAuthor(setAuthor);
                        System.out.println("Updated successfully.\n5 - Author: " + books.get(bookToUpdate).getAuthor());
                    }
                    case "6" -> {
                        System.out.println("6 - Language: " + books.get(bookToUpdate).getLanguage());
                        String setLanguage = Utils.askString(reader, "Change to: ");
                        books.get(bookToUpdate).setLanguage(setLanguage);
                        System.out.println("Updated successfully.\n6 - Language: " + books.get(bookToUpdate).getLanguage());
                    }
                    case "7" -> {
                        System.out.println("7 - Publisher: " + books.get(bookToUpdate).getPublisher());
                        String setPublisher = Utils.askString(reader, "Change to: ");
                        books.get(bookToUpdate).setPublisher(setPublisher);
                        System.out.println("Updated successfully.\n7 - Publisher: " + books.get(bookToUpdate).getPublisher());
                    }
                    case "8" -> {
                        System.out.println("8 - Matter: " + books.get(bookToUpdate).getMatter());
                        String setMatter = Utils.askString(reader, "Change to: ");
                        books.get(bookToUpdate).setMatter(setMatter);
                        System.out.println("Updated successfully.\n8 - Matter: " + books.get(bookToUpdate).getMatter());
                    }
                    case "9" -> System.out.println("Change this parameter from the borrows section");
                    default -> System.out.println("This parameter doesn't exist");
                }
            }
        } else {
            System.out.println(bookToUpdate + ": This book doesn't Exist");
        }
    }

    public static void getAllBooks(){
        System.out.println("All books in the Library:\n");
        int i = 0;
        for (String book: books.keySet()){
            System.out.println(books.get(book));
            i++;
        }
        System.out.println("Total Books: " + i);
    }
}

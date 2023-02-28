package org.example;

import org.example.manager.BookManager;
import org.example.manager.BorrowManager;
import org.example.manager.UserManager;
import org.example.model.Book;

import java.util.Map;


public class App {
    public static void main(String[] args) {

        System.out.println("Users:");
        UserManager.createUsers(5);
        //System.out.println(DataValues.getIdNumber());
        System.out.println(" ");

        System.out.println("Books:");
        BookManager.createBooks(5);
        //System.out.println(DataValues.getIdBook());
        System.out.println(" ");

        System.out.println("Borrows:");
        BorrowManager.createBorrows(2);
        System.out.println(" ");

        // https://parzibyte.me/blog/2020/01/07/hashmap-java-tutorial-ejemplos/
        for (Map.Entry<String, Book> book : BookManager.books.entrySet()) {
            System.out.print(book.toString());
        }



    }
}

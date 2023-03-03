package org.example;

import org.example.manager.BookManager;
import org.example.manager.BorrowManager;
import org.example.manager.UserManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("----- Users: -----");
        UserManager.createUsers(5);
        //System.out.println(DataValues.getIdNumber());
        System.out.println(" ");

        System.out.println("----- Books: -----");
        BookManager.createBooks(5);
        //System.out.println(DataValues.getIdBook());
        System.out.println(" ");

        System.out.println("----- Borrows: -----");
        BorrowManager.createBorrows(2);
        System.out.println(" ");

        BorrowManager.borrowStatus();
        System.out.println(" ");

        //BookManager.createBookToStorage(reader);
        //BorrowManager.borrowStatus();

        //BookManager.deleteBook(reader);
        //BorrowManager.borrowStatus();

        //BookManager.updateBook(reader);

        BookManager.getAllBooks();

        // git proof

    }
}

package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.example.manager.BookManager;
import org.example.manager.BorrowManager;
import org.example.manager.UserManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

import static java.lang.System.out;

@SpringBootApplication
@RestController
public class App {

    @RequestMapping("/")
    String home(){
        return "Main page Library\n " +
                "/users\n " +
                "/users/{getUser}\n" +
                "/users/{deleteUser}\n";
    }
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

        /*
        Scanner reader = new Scanner(System.in);

        System.out.println("----- Users: -----");
        UserManager.createUsers(5);00
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

        BookManager.getAllBooks();*/



    }
}

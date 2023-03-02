package org.example;

import org.example.data.DataValues;
import org.example.manager.BookManager;
import org.example.manager.UserManager;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        UserManager.createUsers(4);

        System.out.println(DataValues.getIdNumber());
        System.out.println(" ");

        UserManager.createUsers(7);

        System.out.println(DataValues.getIdNumber());
        System.out.println(" ");

        BookManager.createBooks(5);

        //System.out.println(DataValues.getIdBook());
        System.out.println(" ");

        BookManager.createBooks(2);



    }
}

package org.example.manager;

import com.github.javafaker.Faker;
import org.example.service.BookService;
import org.example.service.UserService;
import org.example.utils.DataValues;
import org.example.model.Book;
import org.example.model.Borrow;

import java.time.LocalDateTime;
import java.util.*;

public class BorrowManager {

    //public static Map<String, Borrow> borrows = new HashMap<>();



    public static void borrowStatus(){
        System.out.println("----- Borrow Status: -----");
        // https://parzibyte.me/blog/2020/01/07/hashmap-java-tutorial-ejemplos/
        for (Map.Entry<String, Book> book : BookService.books.entrySet()) {
            //System.out.print(book.getKey() + "\n");
            if (book.getValue().isAvailable()){
                System.out.println("Available: " + book.getKey());
            }else{
                System.out.println("Borrowed: " + book.getKey());
            }
        }
    }
}

package org.example.manager;

import com.github.javafaker.Faker;
import org.example.utils.DataValues;
import org.example.model.Book;
import org.example.model.Borrow;

import java.time.LocalDateTime;
import java.util.*;

public class BorrowManager {

    public static Map<String, Borrow> borrows = new HashMap<>();

    public static void createBorrows(int borrowsNumber){
        Faker faker = new Faker();

        Borrow newBorrow;

        for (int i = 0; i <borrowsNumber; i++) {
            LocalDateTime date = LocalDateTime.now();

            ArrayList<String> booksList = new ArrayList<>(BookManager.books.keySet());
            String book = booksList.get(faker.random().nextInt(0,booksList.size()-1));

            ArrayList<String> usersList = new ArrayList<>(UserManager.users.keySet());
            String user = usersList.get(faker.random().nextInt(0, usersList.size()-1));

            String idBorrow = DataValues.createUUID();

            newBorrow = new Borrow(
                    idBorrow,
                    date,
                    date.plusDays(30),
                    null,
                    "Borrowed",
                    BookManager.books.get(book),
                    UserManager.users.get(user),
                    "059"

            );

            BookManager.books.get(book).setAvailable(false); // on proof

            borrows.put(idBorrow,newBorrow);
            System.out.println(newBorrow);

        }

    }

    public static void borrowStatus(){
        System.out.println("----- Borrow Status: -----");
        // https://parzibyte.me/blog/2020/01/07/hashmap-java-tutorial-ejemplos/
        for (Map.Entry<String, Book> book : BookManager.books.entrySet()) {
            //System.out.print(book.getKey() + "\n");
            if (book.getValue().isAvailable()){
                System.out.println("Available: " + book.getKey());
            }else{
                System.out.println("Borrowed: " + book.getKey());
            }
        }
    }
}

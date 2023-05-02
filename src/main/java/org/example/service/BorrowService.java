package org.example.service;

import org.example.model.Book;
import org.example.model.Borrow;
import org.example.model.User;
import org.example.utils.DataValues;
import org.example.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class BorrowService {

    public static Map<String, Borrow> borrows = new HashMap<>();

    static {
        Utils.createBorrows(borrows, 20);
    }

    public Map<String, Borrow> getBorrows() {
        return borrows;
    }

    public Borrow getBorrow(String id) {
        return borrows.get(id);
    }

    public String createBorrow(String bookId, String userId) {
        String response = "";
        String errors = "";

        Borrow newBorrow;

        String idBorrow = DataValues.createUUID();
        LocalDateTime date = LocalDateTime.now();
        Book book = BookService.books.get(bookId);
        User user = UserService.users.get(userId);

        //System.out.println(book);
        //System.out.println(user);

        if (user == null) {
            errors += "User not exist. ";
        }else if (book == null){
            errors += "Book not exist. ";
        }else{
            newBorrow = new Borrow(
                    idBorrow,
                    date,
                    date.plusDays(30),
                    30,
                    null,
                    "Borrowed",
                    book,
                    user,
                    "033"
            );

            if (BookService.books.get(bookId).isAvailable()) {
                BookService.books.get(bookId).setAvailable(false);
                borrows.put(idBorrow,newBorrow);
                response += "Borrow created successfully. \n" + newBorrow;
            }else{
                response += "Book is on borrow.";
            }
        }

        return  response + errors;
    }

    public Map<String, Borrow> getBorrowsById(ArrayList<String> idBorrowsByUser) {
        Map<String, Borrow> borrowsById = new HashMap<>();
        for (String idBorrow : idBorrowsByUser) {
            for (String borrow : borrows.keySet()) {
                if (borrow.equals(idBorrow)) {
                    borrowsById.put(idBorrow, borrows.get(borrow));
                }
            }
        }
        return borrowsById;
    }


}

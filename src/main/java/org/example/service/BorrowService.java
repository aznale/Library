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

    public HashMap<String, String> createBorrow(String bookId, String userId) {

        HashMap<String, String> borrow = new HashMap<>();

        User user = UserService.users.get(userId);
        if (user == null) {
            borrow.put("statusDescription", "User doesn't exist." + userId);
            borrow.put("status", "fail");
            return borrow;
        }

        Book book = BookService.books.get(bookId);
        if (book == null) {
            borrow.put("statusDescription", "Book doesn't exist." + bookId);
            borrow.put("status", "fail");
            return borrow;
        }

        if (!BookService.books.get(bookId).isAvailable()) {
            borrow.put("statusDescription", "Book is on Borrow" + book);
            borrow.put("status", "onBorrow");
            return borrow;
        }

        Borrow newBorrow;

        String idBorrow = DataValues.createUUID();
        LocalDateTime date = LocalDateTime.now();

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


        BookService.books.get(bookId).setAvailable(false);
        borrows.put(idBorrow, newBorrow);
        borrow.put("statusDescription", "Borrow created successfully." + newBorrow);
        borrow.put("status", "succes");


        return borrow;
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

package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    private String borrowId;
    private LocalDateTime initialBorrow;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private String borrowStatus;
    private Book book;
    private User user;
    // Add Library code from borrow (assume return in the same library)
    private String library;

    @Override
    public String toString() {
        return  "borrowId = " + borrowId + '\n' +
                "initialBorrow = " + initialBorrow + '\n' +
                "dueDate = " + dueDate +'\n' +
                "returnDate = " + returnDate +'\n' +
                "borrowStatus = " + borrowStatus +'\n' +
                "book = " + book.getTitle() +'\n' +
                "user = " + user.getName() + ' ' + user.getSurname() +'\n' +
                "library = " + library + '\n'
                ;
    }

}

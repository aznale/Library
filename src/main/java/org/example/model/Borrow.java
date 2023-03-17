package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    private String borrowId;
    private LocalDateTime initialBorrow;     // https://www.delftstack.com/es/howto/java/how-to-add-one-day-to-a-date-in-java/
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private String borrowStatus;
    private Book book;
    private User user;
    private String library; // Add Library code from borrow (assume return in the same library)

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

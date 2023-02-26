package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    private String borrowId;
    private Date initialBorrow;
    private Date dueDate;
    private Date returnDate;
    private String borrowStatus;
    private Book book;
    private User user;
    // Add Library code from borrow (assume return in the same library)
    private String library;

}

package org.example.controller;

import org.example.model.Book;
import org.example.model.Borrow;
import org.example.model.User;
import org.example.service.BookService;
import org.example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    BorrowService borrowService;
    @Autowired
    BookService bookService;

    @RequestMapping("/borrows")
    public String getBorrows(Model model) {
        model.addAttribute("borrows", borrowService.getBorrows());
        return "borrowManagerView";
    }

    @RequestMapping("/returnBook")
    public String returnBook(@RequestParam("idBorrow") String id, @RequestParam("idBook") String idBook) {
        Borrow borrowFound = borrowService.getBorrow(id);
        Book borrowFoundBook = bookService.getBook(idBook);
        if (borrowFound != null && borrowFound.getReturnDate() == null) {
            borrowFound.setBorrowStatus("Available");
            borrowFound.setReturnDate(LocalDateTime.now());
            borrowFoundBook.setAvailable(true);
        }
        return "redirect:/borrow/borrows";
    }

    @RequestMapping("/renovateBook")
    public String renovateBook(@RequestParam("idBorrow") String id){
        Borrow borrowFound = borrowService.getBorrow(id);
        if (borrowFound != null && borrowFound.getReturnDate() == null && borrowFound.getBorrowDays() < 60) {
            borrowFound.setDueDate(borrowFound.getDueDate().plusDays(15));
            borrowFound.setBorrowDays(borrowFound.getBorrowDays() + 15);
        }
        return "redirect:/borrow/borrows";
    }




}

package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "bookManagerView";
    }

    @RequestMapping("/emptyCreateBook")
    public String emptyCreateBook() {
        return "createBook";
    }

    @RequestMapping("/createBook")
    public String createBook(Book book){
        bookService.createBook(book);
        return "redirect:books";
    }

    @RequestMapping("/bookCard")
    public String bookCard(@RequestParam("idBook") String id, Model model) {
        Book bookFound = bookService.getBook(id);
        if (bookFound != null) {
            model.addAttribute("bookSendToForm", bookFound);
            model.addAttribute("message", "User found");
        } else {
            model.addAttribute("message", "User not found");
        }
        return "editBook";
    }

    @PostMapping("/updateBook/{idBook}")
    public String updateBook(@PathVariable("idBook") String id, Book book) {
        Book bookFound = bookService.getBook(id);
        if (bookFound != null) {
            bookService.updateBook(id, book);
            return "redirect:/book/books";
        }
        return "book/bookNotFound";// TODO implement bookNot Found and this template
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("idBook") String id) {
        Book bookFound = bookService.getBook(id);
        System.out.println(bookFound);
        if (bookFound != null) {
            bookService.deleteBook(id);
            return "redirect:/book/books";
        }
        return "home"; // TODO implement bookNot Found and this template
    }

}

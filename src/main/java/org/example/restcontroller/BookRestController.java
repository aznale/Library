package org.example.restcontroller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public Map<String, Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/aBook")
    public Book getBook(String id){
        return  bookService.getBook(id);
    }


}

package org.example.restcontroller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public Map<String, Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/aBook")
    public Book getBook(@RequestParam("bookId") String id) {
        return bookService.getBook(id);
    }

    @PostMapping("/createBook")
    public String createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return "Book created: \n" + bookService.getBook(book.getBookId()).toString();
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") String id) {
        return bookService.deleteBook(id);

    }

}

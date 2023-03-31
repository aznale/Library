package org.example.service;

import org.example.model.Book;
import org.example.utils.DataValues;
import org.example.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    public static Map<String, Book> books = new HashMap<>();

    static {
        Utils.createBooks(books, 100);
    }

    public Map<String, Book> getAllBooks() {
        return books;
    }

    public void createBook(Book book) {
        int sumNewMaxId = DataValues.getIdBook();
        String stringSumNewMaxId = String.format("%07d", sumNewMaxId);
        book.setBookId(stringSumNewMaxId);
        books.put(stringSumNewMaxId, book);
        DataValues.setIdBook(sumNewMaxId + 1);
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public void updateBook(String id, Book book) {
        book.setBookId(id);
        books.put(id, book);
    }

    public String deleteBook(String id) {
        String response;
        if (books.get(id).isAvailable()) {
            response = "Boook deleted: \n" + books.get(id).toString();
            books.remove(id);
        } else {
            response = books.get(id).getTitle() + " the book is on borrow. Unable to delete it.";
        }

        return response;
    }
}

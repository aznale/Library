package org.example.service;

import org.example.manager.BookManager;
import org.example.model.Book;
import org.example.utils.DataValues;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    public static Map<String, Book> books = new HashMap<>();

    static{
        BookManager.createBooks(books,20);
    }

    public Map<String, Book> getAllBooks() {
        return books;
    }

    public void createBook(Book book){
        int sumNewMaxId = DataValues.getIdBook();
        String stringSumNewMaxId = String.format("%07d",sumNewMaxId);
        book.setBookId(stringSumNewMaxId);
        books.put(stringSumNewMaxId,book);
        DataValues.setIdBook(sumNewMaxId+1);
    }

    public Book getBook(String id){
        return books.get(id);
    }

    public void updateBook(String id, Book book){
        book.setBookId(id);
        books.put(id, book);
    }

    public void deleteBook(String id){
        books.remove(id);
    }
}

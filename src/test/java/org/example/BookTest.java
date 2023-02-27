package org.example;

import org.example.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private final Book book = new Book("Acconci,Vito -6574839664-", "978-84-343-0889-3","Vito acconci: escritos, obras y proyectos", "2001","Vito Acconci","Castellà","Polígrafa Artbooks","Contemporary Art",true);
    //https://www.culturaydeporte.gob.es/webISBN/tituloDetalle.do?sidTitul=1115201&action=busquedaInicial&noValidating=true&POS=0&MAX=50&TOTAL=0&layout=busquedaisbn&language=es&prev_layout=busquedaisbn

    @Test
    public void getBook(){
        assertAll("book",
                ()-> assertEquals("Acconci,Vito -6574839664-", book.getBookId()),
                ()-> assertEquals("978-84-343-0889-3", book.getISBN()),
                ()-> assertEquals("Vito acconci: escritos, obras y proyectos", book.getTitle()),
                ()-> assertEquals("2001", book.getYearPublication()),
                ()-> assertEquals("Vito Acconci", book.getAuthor()),
                ()-> assertEquals("Castellà", book.getLanguage()),
                ()-> assertEquals("Polígrafa Artbooks", book.getPublisher()),
                ()-> assertEquals("Contemporary Art", book.getMatter()),
                ()-> assertTrue(book.isAvailable())

        );

        System.out.println(book);
    }

    @Test
    public void setBook(){

        System.out.println(book);

        book.setBookId("set_bookId");
        book.setISBN("set_ISBN");
        book.setTitle("set_title");
        book.setYearPublication("set_YearPublication");
        book.setAuthor("set_Author");
        book.setLanguage("set_Language");
        book.setPublisher("set_Publisher");
        book.setMatter("set_Matter");
        book.setAvailable(false);

        assertAll("book",
                ()-> assertEquals("set_bookId", book.getBookId()),
                ()-> assertEquals("set_ISBN", book.getISBN()),
                ()-> assertEquals("set_title", book.getTitle()),
                ()-> assertEquals("set_YearPublication", book.getYearPublication()),
                ()-> assertEquals("set_Author", book.getAuthor()),
                ()-> assertEquals("set_Language", book.getLanguage()),
                ()-> assertEquals("set_Publisher", book.getPublisher()),
                ()-> assertEquals("set_Matter", book.getMatter()),
                ()-> assertFalse(book.isAvailable())

        );

        System.out.println(book);

    }

}

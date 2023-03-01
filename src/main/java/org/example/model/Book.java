package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookId; // TODO append idLibrary? or *
    private String ISBN;
    private String title;
    private String yearPublication;
    private String author;
    private String language;
    private String publisher;
    private String matter;
    private boolean available = true; // For control individual borrow

    // TODO * add att.code of specific library to which the book belongs

    @Override
    public String toString() {
        String borrowedMessage = "Available";
        if (!this.available) {
            borrowedMessage = "Borrowed";
        }

        return  "bookId = " + bookId + '\n' +
                "ISBN = " + ISBN + '\n' +
                "title = " + title + '\n' +
                "yearPublication = " + yearPublication + '\n' +
                "author = " + author + '\n' +
                "language = " + language + '\n' +
                "publisher = " + publisher + '\n' +
                "matter = " + matter + '\n' +
                "available = " + borrowedMessage +
                '\n';
    }
}

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

        return  "1 - Book Id: " + bookId + '\n' +
                "2 - ISBN: " + ISBN + '\n' +
                "3 - Title: " + title + '\n' +
                "4 - Year Publication: " + yearPublication + '\n' +
                "5 - Author: " + author + '\n' +
                "6 - Language: " + language + '\n' +
                "7 - Publisher: " + publisher + '\n' +
                "8 - Matter: " + matter + '\n' +
                "9 - Available: " + borrowedMessage +
                '\n';
    }
}

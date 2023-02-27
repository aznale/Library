package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookId; // TODO append idLibrary?
    private String ISBN;
    private String title;
    private String yearPublication;
    private String author;
    private String language;
    private String publisher;
    private String matter;
    private boolean available = true; // For control individual borrow

    @Override
    public String toString() {
        String borrowedMessage = "Available";
        if (!this.available) {
            borrowedMessage = "Borrowed";
        }

        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", yearPublication='" + yearPublication + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", publisher='" + publisher + '\'' +
                ", matter='" + matter + '\'' +
                ", available='" + borrowedMessage +
                '}';
    }
}

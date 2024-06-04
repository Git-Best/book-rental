package org.msa.service.book.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.msa.service.book.domain.vo.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long no;

    private String title;

    private BookDescription description;

    private Classification classification;

    private BookStatus bookStatus;

    private Location location;

    public static Book enterBook(String title, String author, String isbn, String description, LocalDate publicationDate, Source source, Classification classification, Location location) {
        BookDescription bookDesc = BookDescription.createBookDesc(author, isbn, description, publicationDate, source);
        Book book = new Book();
        book.title = title;
        book.description = bookDesc;
        book.classification = classification;
        book.location = location;
        book.bookStatus = BookStatus.AVAILABLE;
        return book;
    }

    public Book makeAvailable() {
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }

    public Book makeUnAvailable() {
        this.setBookStatus(BookStatus.UNAVAILABLE);
        return this;
    }
}

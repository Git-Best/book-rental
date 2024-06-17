package org.msa.service.book.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookDescription {
    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private Source source;

    public static BookDescription createBookDesc(String author, String isbn, String description, LocalDate publicationDate, Source source) {
        return new BookDescription(description, author, isbn, publicationDate, source);
    }
}

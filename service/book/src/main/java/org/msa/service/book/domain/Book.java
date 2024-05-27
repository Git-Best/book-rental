package org.msa.service.book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msa.service.book.domain.vo.BookDescription;
import org.msa.service.book.domain.vo.BookStatus;
import org.msa.service.book.domain.vo.Classification;
import org.msa.service.book.domain.vo.Location;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long no;
    private String title;
    private BookDescription description;
    private Classification classification;
    private BookStatus bookStatus;
    private Location location;
}

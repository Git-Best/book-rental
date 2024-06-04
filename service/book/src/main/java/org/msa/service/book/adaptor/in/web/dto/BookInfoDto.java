package org.msa.service.book.adaptor.in.web.dto;

import java.time.LocalDate;

public record BookInfoDto(
        String title,
        String description,
        String author,
        String isbn,
        LocalDate publicationDate,
        String source,
        String classification,
        String location
) {
}

package org.msa.service.book.adaptor.in.web.dto;

import org.msa.service.book.domain.Book;

public record BookOutputDto(long bookNo, String bookTitle, String bookStatus) {

    public static BookOutputDto mapToDto(Book book) {
        return new BookOutputDto(book.getNo(), book.getTitle(), book.getBookStatus().toString());
    }
}

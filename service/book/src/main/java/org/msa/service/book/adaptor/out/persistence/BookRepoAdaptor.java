package org.msa.service.book.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import org.msa.service.book.application.port.out.BookRepoPort;
import org.msa.service.book.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepoAdaptor implements BookRepoPort {

    private final BookRepo bookRepo;

    @Override
    public Book loadBook(Long bookNo) {
        return null;
    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }
}

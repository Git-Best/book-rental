package org.msa.service.book.application.port.out;

import org.msa.service.book.domain.Book;

public interface BookRepoPort {
    Book loadBook(Long bookNo);
    Book saveBook(Book book);
}

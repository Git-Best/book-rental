package org.msa.service.book.application.port.in;

import org.msa.service.book.adaptor.in.web.dto.BookInfoDto;
import org.msa.service.book.adaptor.in.web.dto.BookOutputDto;

public interface AddBookService {
    BookOutputDto addBook(BookInfoDto bookInfoDto);
}

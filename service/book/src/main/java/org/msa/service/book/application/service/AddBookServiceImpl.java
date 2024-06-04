package org.msa.service.book.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.book.adaptor.in.web.dto.BookInfoDto;
import org.msa.service.book.adaptor.in.web.dto.BookOutputDto;
import org.msa.service.book.application.port.in.AddBookService;
import org.msa.service.book.application.port.out.BookRepoPort;
import org.msa.service.book.domain.Book;
import org.msa.service.book.domain.vo.Classification;
import org.msa.service.book.domain.vo.Location;
import org.msa.service.book.domain.vo.Source;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class AddBookServiceImpl implements AddBookService {

    private BookRepoPort bookRepoPort;

    @Override
    public BookOutputDto addBook(BookInfoDto bookInfoDto) {
        Book book = Book.enterBook(bookInfoDto.title(), bookInfoDto.author(), bookInfoDto.isbn(), bookInfoDto.description(), bookInfoDto.publicationDate(), Source.valueOf(bookInfoDto.source()), Classification.valueOf(bookInfoDto.classification()), Location.valueOf(bookInfoDto.location()));
        Book savedBook = bookRepoPort.saveBook(book);
        return BookOutputDto.mapToDto(savedBook);
    }
}

package org.msa.service.book.application.service;

import lombok.RequiredArgsConstructor;
import org.msa.service.book.adaptor.in.web.dto.BookOutputDto;
import org.msa.service.book.application.port.in.MakeUnAvailableService;
import org.msa.service.book.application.port.out.BookRepoPort;
import org.msa.service.book.domain.Book;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakeUnAvailableServiceImpl implements MakeUnAvailableService {

    private final BookRepoPort bookRepoPort;

    @Override
    public BookOutputDto unAvailable(Long bookNo) {
        Book book = bookRepoPort.loadBook(bookNo);
        book.makeUnAvailable();
        return BookOutputDto.mapToDto(book);
    }
}

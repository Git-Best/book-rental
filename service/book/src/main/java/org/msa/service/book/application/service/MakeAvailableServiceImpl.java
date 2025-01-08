package org.msa.service.book.application.service;

import lombok.RequiredArgsConstructor;
import org.msa.service.book.adaptor.in.web.dto.BookOutputDto;
import org.msa.service.book.application.port.in.MakeAvailableService;
import org.msa.service.book.application.port.out.BookRepoPort;
import org.msa.service.book.domain.Book;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakeAvailableServiceImpl implements MakeAvailableService {

    private final BookRepoPort bookRepoPort;

    @Override
    public BookOutputDto available(Long bookNo) {
        Book book = bookRepoPort.loadBook(bookNo);
        book.makeAvailable();
        return BookOutputDto.mapToDto(book);
    }
}

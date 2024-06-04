package org.msa.service.book.application.service;

import lombok.RequiredArgsConstructor;
import org.msa.service.book.adaptor.in.web.dto.BookOutputDto;
import org.msa.service.book.application.port.in.InquiryService;
import org.msa.service.book.application.port.out.BookRepoPort;
import org.msa.service.book.domain.Book;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

    private final BookRepoPort bookRepoPort;

    @Override
    public BookOutputDto getBookInfo(long bookNo) {
        Book book = bookRepoPort.loadBook(bookNo);
        return BookOutputDto.mapToDto(book);
    }
}

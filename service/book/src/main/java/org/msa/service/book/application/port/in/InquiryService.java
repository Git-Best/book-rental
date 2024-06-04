package org.msa.service.book.application.port.in;

import org.msa.service.book.adaptor.in.web.dto.BookOutputDto;

public interface InquiryService {
    BookOutputDto getBookInfo(long bookNo);
}

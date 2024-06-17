package org.msa.service.book.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import org.msa.service.book.adaptor.in.web.dto.BookInfoDto;
import org.msa.service.book.adaptor.in.web.dto.BookOutputDto;
import org.msa.service.book.application.port.in.AddBookService;
import org.msa.service.book.application.port.in.InquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final AddBookService addBookService;
    private final InquiryService inquiryService;

    @PostMapping("/book")
    public ResponseEntity<BookOutputDto> createBook(@RequestBody BookInfoDto bookInfoDto) {
        BookOutputDto bookOutputDto = addBookService.addBook(bookInfoDto);
        return new ResponseEntity<>(bookOutputDto, HttpStatus.CREATED);
    }

    @GetMapping("/book/{bookNo}")
    public ResponseEntity<BookOutputDto> getBook(@PathVariable long bookNo) {
        BookOutputDto bookOutputDto = inquiryService.getBookInfo(bookNo);
        return bookOutputDto != null ? new ResponseEntity<>(bookOutputDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package org.msa.service.bestbook.domain;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.msa.service.bestbook.domain.model.BestBook;
import org.msa.service.bestbook.domain.model.Item;
import org.msa.service.bestbook.persistence.BestBookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BestBookService {

    private final BestBookRepository bookRepository;

    public List<BestBook> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BestBook> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public void dealBestBook(Item item) {
        BestBook bestBook = bookRepository.findBestBookByItem(item);
        if(bestBook == null) {
            bestBook = BestBook.regiseterBestBook(item);
        } else {
            bestBook.increaseBestBookCount();
        }

        bookRepository.save(bestBook);
    }

    public BestBook updateBook(String id, BestBook book) {
        Optional<BestBook> existingBookOptional = bookRepository.findById(id);
        if(existingBookOptional.isPresent()) {
            BestBook existingBook = existingBookOptional.get();
            existingBook.setItem(book.getItem());
            existingBook.setRentCount(book.getRentCount());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    public boolean deleteBook(String id) {
        Optional<BestBook> existingBookOptional = bookRepository.findById(id);
        if(existingBookOptional.isPresent()) {
            bookRepository.delete(existingBookOptional.get());
            return true;
        }
        return false;
    }
}

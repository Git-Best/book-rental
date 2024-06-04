package org.msa.service.book.adaptor.out.persistence;

import org.msa.service.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}

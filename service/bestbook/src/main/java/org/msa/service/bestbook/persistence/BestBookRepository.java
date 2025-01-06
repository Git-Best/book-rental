package org.msa.service.bestbook.persistence;

import org.msa.service.bestbook.domain.model.BestBook;
import org.msa.service.bestbook.domain.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BestBookRepository extends MongoRepository<BestBook, String> {
    public BestBook findBestBookByItem(Item item);
}

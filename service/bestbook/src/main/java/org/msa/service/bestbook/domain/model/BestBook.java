package org.msa.service.bestbook.domain.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestBook {

    @Id
    private String id;
    private Item item;
    private long rentCount;

    public static BestBook regiseterBestBook(Item item) {
        UUID uuid = UUID.randomUUID();
        BestBook bestBook = new BestBook();
        bestBook.setId(uuid.toString());
        bestBook.setItem(item);
        bestBook.setRentCount(1L);
        return bestBook;
    }

    public Long increaseBestBookCount() {
        this.rentCount = this.getRentCount() + 1;
        return this.rentCount;
    }
}

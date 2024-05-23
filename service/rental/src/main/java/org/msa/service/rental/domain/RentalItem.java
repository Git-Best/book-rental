package org.msa.service.rental.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msa.service.rental.domain.vo.Item;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RentalItem {

    @Embedded
    private Item item;
    private LocalDate rentDate;

    private boolean overdued;

    private LocalDate overdueDate;

    public static RentalItem createRentalItem(Item item) {
        return new RentalItem(item, LocalDate.now(), false, LocalDate.now().plusDays(14));
    }
}

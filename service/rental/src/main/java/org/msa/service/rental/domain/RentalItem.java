package org.msa.service.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msa.service.rental.domain.vo.Item;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalItem {
    private Item item;
    private LocalDate rentDate;

    private boolean overdued;

    private LocalDate overdueDate;

    public static RentalItem createRentalItem(Item item) {
        return new RentalItem(item, LocalDate.now(), false, LocalDate.now().plusDays(14));
    }
}

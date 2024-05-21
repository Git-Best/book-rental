package org.msa.service.rental.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msa.service.rental.domain.RentalItem;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnItem {
    private RentalItem rentalItem;
    private LocalDate returnDate;

    public static ReturnItem createReturnItem(RentalItem rentalItem) {
        return new ReturnItem(rentalItem, LocalDate.now());
    }
}

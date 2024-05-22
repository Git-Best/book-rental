package org.msa.service.rental.adaptor.in.web.dto;

import lombok.Data;
import org.msa.service.rental.domain.RentalItem;

import java.time.LocalDate;

@Data
public class RentItemOutputDto {
    private Integer itemNo;
    private String itemTitle;
    private LocalDate rentDate;
    private boolean overdued;
    private LocalDate overdueDate;

    public static RentItemOutputDto mapToDto(RentalItem rentalItem) {
        RentItemOutputDto dto = new RentItemOutputDto();
        dto.setItemNo(rentalItem.getItem().getNo());
        dto.setItemTitle(rentalItem.getItem().getTitle());
        dto.setRentDate(rentalItem.getRentDate());
        dto.setOverdued(rentalItem.isOverdued());
        dto.setOverdueDate(rentalItem.getOverdueDate());
        return dto;
    }
}

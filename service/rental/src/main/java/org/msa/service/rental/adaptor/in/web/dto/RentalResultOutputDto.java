package org.msa.service.rental.adaptor.in.web.dto;

import lombok.Data;
import org.msa.service.rental.domain.RentalCard;

@Data
public class RentalResultOutputDto {
    private String userId;
    private String userName;
    private Integer rentedCount;
    private long totalLateFee;

    public static RentalResultOutputDto mapToDto(RentalCard rentalCard) {
        RentalResultOutputDto dto = new RentalResultOutputDto();
        dto.setUserId(rentalCard.getMember().getId());
        dto.setUserName(rentalCard.getMember().getName());
        dto.setRentedCount(rentalCard.getRentalItemList().size());
        dto.setTotalLateFee(rentalCard.getLateFee().getPoint());
        return dto;
    }
}

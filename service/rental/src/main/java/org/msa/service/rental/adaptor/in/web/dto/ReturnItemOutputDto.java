package org.msa.service.rental.adaptor.in.web.dto;


import lombok.Data;
import org.msa.service.rental.domain.vo.ReturnItem;

import java.time.LocalDate;

@Data
public class ReturnItemOutputDto {
    private Integer itemNo;
    private String itemTitle;
    private LocalDate returnDate;

    public static ReturnItemOutputDto mapToDto(ReturnItem returnItem) {
        ReturnItemOutputDto dto = new ReturnItemOutputDto();
        dto.setItemNo(returnItem.getRentalItem().getItem().getNo());
        dto.setItemTitle(returnItem.getRentalItem().getItem().getTitle());
        dto.setReturnDate(returnItem.getReturnDate());
        return dto;
    }
}

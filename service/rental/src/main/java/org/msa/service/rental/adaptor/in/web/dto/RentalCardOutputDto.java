package org.msa.service.rental.adaptor.in.web.dto;

import lombok.*;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.RentalItem;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalCardOutputDto {
    private String rentalCardId;
    private String memberId;
    private String memberName;
    private String rentStatus;
    private Long totalLateFee;
    private Long totalRentalCnt;
    private Long totalReturnCnt;
    private Long totalOverduedCnt;

    public static RentalCardOutputDto mapToDto(RentalCard rentalCard) {
        RentalCardOutputDto dto = new RentalCardOutputDto();
        dto.setRentalCardId(rentalCard.getRentalCardNo().getNo());
        dto.setMemberId(rentalCard.getMember().getId());
        dto.setMemberName(rentalCard.getMember().getName());
        dto.setRentStatus(rentalCard.getRentStatus().toString());
        dto.setTotalRentalCnt((long) rentalCard.getRentalItemList().size());
        dto.setTotalReturnCnt((long)rentalCard.getReturnItemList().size());
        dto.setTotalOverduedCnt(rentalCard.getRentalItemList().stream().filter(RentalItem::isOverdued).count());
        return dto;
    }
}

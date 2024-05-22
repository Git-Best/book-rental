package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalResultOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.clearOverdueInfoDto;
import org.msa.service.rental.application.port.in.ClearOverdueItemService;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ClearOverdueItemServiceImpl implements ClearOverdueItemService {

    private final RentalCardRepoPort rentalCardRepoPort;

    @Override
    public RentalResultOutputDto clearOverdueItem(clearOverdueInfoDto clearOverdueInfoDto) {
        RentalCard rentalCard = rentalCardRepoPort.loadRentalCard(clearOverdueInfoDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("RentalCard not found"));
        rentalCard.makeAvailableRental(clearOverdueInfoDto.getPoint());

        return RentalResultOutputDto.mapToDto(rentalCard);
    }
}

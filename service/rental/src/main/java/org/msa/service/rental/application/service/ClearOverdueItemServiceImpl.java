package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalResultOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.ClearOverdueInfoDto;
import org.msa.service.rental.application.port.in.ClearOverdueItemService;
import org.msa.service.rental.application.port.out.EventPort;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.event.OverdueCleared;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ClearOverdueItemServiceImpl implements ClearOverdueItemService {

    private final RentalCardRepoPort rentalCardRepoPort;
    private final EventPort eventPort;

    @Override
    public RentalResultOutputDto clearOverdueItem(ClearOverdueInfoDto clearOverdueInfoDto) throws Exception {
        RentalCard rentalCard = rentalCardRepoPort.loadRentalCard(clearOverdueInfoDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("RentalCard not found"));

        rentalCard.makeAvailableRental(clearOverdueInfoDto.getPoint());

        OverdueCleared overdueClearedEvent = RentalCard.createOverdueClearedEvent(rentalCard.getMember(), clearOverdueInfoDto.getPoint());
        eventPort.occurOverdueClearedEvent(overdueClearedEvent);

        return RentalResultOutputDto.mapToDto(rentalCard);
    }
}

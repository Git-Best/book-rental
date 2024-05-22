package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserItemInputDto;
import org.msa.service.rental.application.port.in.OverdueItemService;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.vo.Item;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OverdueItemServiceImpl implements OverdueItemService {

    private final RentalCardRepoPort rentalCardRepoPort;

    @Override
    public RentalCardOutputDto overDueItem(UserItemInputDto owner) {
        RentalCard rentalCard = rentalCardRepoPort.loadRentalCard(owner.getUserId()).orElseThrow(() -> new IllegalArgumentException("RentalCard not found"));
        rentalCard.overdueItem(new Item(owner.getItemId(), owner.getItemTitle()));
        return RentalCardOutputDto.mapToDto(rentalCard);
    }
}

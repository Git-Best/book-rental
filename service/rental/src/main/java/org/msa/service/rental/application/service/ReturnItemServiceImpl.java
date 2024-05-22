package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserItemInputDto;
import org.msa.service.rental.application.port.in.ReturnItemService;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.vo.Item;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnItemServiceImpl implements ReturnItemService {

    private final RentalCardRepoPort rentalCardRepoPort;

    @Override
    public RentalCardOutputDto returnItem(UserItemInputDto owner) {
        RentalCard rentalCard = rentalCardRepoPort.loadRentalCard(owner.getUserId()).orElseThrow(() -> new IllegalArgumentException("RentalCard not found"));
        Item item = new Item(owner.getItemId(), owner.getItemTitle());
        // dirty checking
        rentalCard.returnItem(item, LocalDate.now());
        return RentalCardOutputDto.mapToDto(rentalCard);
    }
}

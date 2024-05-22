package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserItemInputDto;
import org.msa.service.rental.application.port.in.RentItemService;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.vo.IdName;
import org.msa.service.rental.domain.vo.Item;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class RentItemServiceImpl implements RentItemService {

    private final RentalCardRepoPort rentalCardRepoPort;

    @Override
    public RentalCardOutputDto rentItem(UserItemInputDto owner) {
        RentalCard rentalCard = rentalCardRepoPort.loadRentalCard(owner.getUserId()).orElseGet(() -> RentalCard.createRentalCard(new IdName(owner.getUserId(), owner.getUserName())));
        Item item = new Item(owner.getItemId(), owner.getItemTitle());
        rentalCard.rentItem(item);
        //RentalCard save = rentalCardRepoPort.saveRentalCard(rentalCard);
        return RentalCardOutputDto.mapToDto(rentalCard);
    }
}

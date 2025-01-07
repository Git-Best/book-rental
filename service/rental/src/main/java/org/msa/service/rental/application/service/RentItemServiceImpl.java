package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserItemInputDto;
import org.msa.service.rental.application.port.in.RentItemService;
import org.msa.service.rental.application.port.out.EventPort;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.event.ItemRented;
import org.msa.service.rental.domain.vo.IdName;
import org.msa.service.rental.domain.vo.Item;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class RentItemServiceImpl implements RentItemService {

    private final RentalCardRepoPort rentalCardRepoPort;
    private final EventPort eventPort;

    @Override
    public RentalCardOutputDto rentItem(UserItemInputDto owner) throws Exception {
        RentalCard rentalCard = rentalCardRepoPort.loadRentalCard(owner.getUserId()).orElseGet(() -> RentalCard.createRentalCard(new IdName(owner.getUserId(), owner.getUserName())));
        Item item = new Item(owner.getItemId(), owner.getItemTitle());
        rentalCard.rentItem(item);

        // 대여 이벤트 생성 및 발행
        ItemRented itemRentedEvent = RentalCard.createItemRentedEvent(rentalCard.getMember(), item, 10L);
        eventPort.occurRentEvent(itemRentedEvent);

        return RentalCardOutputDto.mapToDto(rentalCard);
    }
}

package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserItemInputDto;
import org.msa.service.rental.application.port.in.ReturnItemService;
import org.msa.service.rental.application.port.out.EventPort;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.event.ItemReturned;
import org.msa.service.rental.domain.vo.Item;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnItemServiceImpl implements ReturnItemService {

    private final RentalCardRepoPort rentalCardRepoPort;
    private final EventPort eventPort;

    @Override
    public RentalCardOutputDto returnItem(UserItemInputDto owner) throws Exception {
        RentalCard rentalCard = rentalCardRepoPort.loadRentalCard(owner.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("RentalCard not found"));

        Item item = new Item(owner.getItemId(), owner.getItemTitle());
        rentalCard.returnItem(item, LocalDate.now());

        // 이벤트 생성 및 발행
        ItemReturned itemReturnedEvent = RentalCard.createItemReturnedEvent(rentalCard.getMember(), item, 10L);
        eventPort.occurReturnEvent(itemReturnedEvent);

        return RentalCardOutputDto.mapToDto(rentalCard);
    }
}

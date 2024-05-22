package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserInputDto;
import org.msa.service.rental.application.port.in.CreateRentalCardService;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.msa.service.rental.domain.vo.IdName;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardServiceImpl implements CreateRentalCardService {

    private final RentalCardRepoPort rentalCardRepoPort;

    @Override
    public RentalCardOutputDto createRentalCard(UserInputDto owner) {
        RentalCard rentalCard = RentalCard.createRentalCard(new IdName(owner.getUserId(), owner.getUserName()));
        RentalCard save = rentalCardRepoPort.saveRentalCard(rentalCard);
        return RentalCardOutputDto.mapToDto(save);
    }
}

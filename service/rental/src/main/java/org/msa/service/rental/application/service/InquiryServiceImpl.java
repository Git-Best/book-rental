package org.msa.service.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.RentItemOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.ReturnItemOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserInputDto;
import org.msa.service.rental.application.port.in.InquiryService;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

    private final RentalCardRepoPort rentalCardRepoPort;

    @Override
    public Optional<RentalCardOutputDto> getRentalCard(UserInputDto userInputDto) {
        return rentalCardRepoPort.loadRentalCard(userInputDto.getUserId()).map(RentalCardOutputDto::mapToDto);
    }

    @Override
    public Optional<List<RentItemOutputDto>> getAllRentItems(UserInputDto userInputDto) {
        return rentalCardRepoPort.loadRentalCard(userInputDto.getUserId())
                .map(loadCard -> loadCard.getRentalItemList().stream()
                        .map(RentItemOutputDto::mapToDto)
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<ReturnItemOutputDto>> getAllReturnItems(UserInputDto userInputDto) {
        return rentalCardRepoPort.loadRentalCard(userInputDto.getUserId())
                .map(loadCard -> loadCard.getReturnItemList().stream()
                        .map(ReturnItemOutputDto::mapToDto)
                        .collect(Collectors.toList()));
    }
}

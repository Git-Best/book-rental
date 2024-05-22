package org.msa.service.rental.application.port.in;

import org.msa.service.rental.adaptor.in.web.dto.RentItemOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.ReturnItemOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserInputDto;

import java.util.List;
import java.util.Optional;

public interface InquiryService {
    Optional<RentalCardOutputDto> getRentalCard(UserInputDto userInputDto);
    Optional<List<RentItemOutputDto>> getAllRentItems(UserInputDto userInputDto);
    Optional<List<ReturnItemOutputDto>> getAllReturnItems(UserInputDto userInputDto);
}

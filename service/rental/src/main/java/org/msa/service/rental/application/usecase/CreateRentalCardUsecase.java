package org.msa.service.rental.application.usecase;

import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserInputDto;

public interface CreateRentalCardUsecase {
    RentalCardOutputDto createRentalCard(UserInputDto userInputDto);
}

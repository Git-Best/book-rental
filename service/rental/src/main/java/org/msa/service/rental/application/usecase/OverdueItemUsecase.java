package org.msa.service.rental.application.usecase;

import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserItemInputDto;

public interface OverdueItemUsecase {
    RentalCardOutputDto overDueItem(UserItemInputDto userItemInputDto);
}

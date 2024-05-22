package org.msa.service.rental.application.usecase;

import org.msa.service.rental.adaptor.in.web.dto.RentalResultOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.clearOverdueInfoDto;

public interface ClearOverdueItemUsecase {
    RentalResultOutputDto clearOverdueItem(clearOverdueInfoDto clearOverdueInfoDto);
}

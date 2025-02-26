package org.msa.service.rental.application.port.in;

import org.msa.service.rental.adaptor.in.web.dto.RentalCardOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.UserItemInputDto;

public interface RentItemService {
    RentalCardOutputDto rentItem(UserItemInputDto userItemInputDto) throws Exception;
}

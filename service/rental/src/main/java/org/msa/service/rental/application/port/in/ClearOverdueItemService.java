package org.msa.service.rental.application.port.in;

import org.msa.service.rental.adaptor.in.web.dto.RentalResultOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.ClearOverdueInfoDto;

public interface ClearOverdueItemService {
    RentalResultOutputDto clearOverdueItem(ClearOverdueInfoDto clearOverdueInfoDto) throws Exception;
}

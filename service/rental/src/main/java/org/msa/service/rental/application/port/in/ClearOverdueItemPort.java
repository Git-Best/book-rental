package org.msa.service.rental.application.port.in;

import org.msa.service.rental.adaptor.in.web.dto.RentalResultOutputDto;
import org.msa.service.rental.adaptor.in.web.dto.clearOverdueInfoDto;

public interface ClearOverdueItemPort {
    RentalResultOutputDto clearOverdueItem(clearOverdueInfoDto clearOverdueInfoDto);
}

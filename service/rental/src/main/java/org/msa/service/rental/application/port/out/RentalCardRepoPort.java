package org.msa.service.rental.application.port.out;

import org.msa.service.rental.domain.RentalCard;

import java.util.Optional;

public interface RentalCardRepoPort {
    Optional<RentalCard> loadRentalCard(String userId);
    RentalCard saveRentalCard(RentalCard rentalCard);
}

package org.msa.service.rental.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RentalCardRepoAdaptor implements RentalCardRepoPort {
    @Override
    public Optional<RentalCard> loadRentalCard(String userId) {
        return Optional.empty();
    }

    @Override
    public RentalCard saveRentalCard(RentalCard rentalCard) {
        return null;
    }
}

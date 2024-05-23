package org.msa.service.rental.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import org.msa.service.rental.application.port.out.RentalCardRepoPort;
import org.msa.service.rental.domain.RentalCard;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RentalCardRepoAdaptor implements RentalCardRepoPort {

    private final RentalCardRepo rentalCardRepository;

    @Override
    public Optional<RentalCard> loadRentalCard(String userId) {
        return rentalCardRepository.findByMemberId(userId);
    }

    @Override
    public RentalCard saveRentalCard(RentalCard rentalCard) {
        return rentalCardRepository.save(rentalCard);
    }
}

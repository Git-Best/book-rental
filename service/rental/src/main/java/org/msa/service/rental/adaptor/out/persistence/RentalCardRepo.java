package org.msa.service.rental.adaptor.out.persistence;

import org.msa.service.rental.domain.RentalCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCardRepo extends JpaRepository<RentalCard, Long> {
}

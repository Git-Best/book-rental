package org.msa.service.rental.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.msa.service.rental.domain.event.ItemRented;
import org.msa.service.rental.domain.event.ItemReturned;
import org.msa.service.rental.domain.event.OverdueCleared;

public interface EventPort {
    public void occurRentEvent(ItemRented itemRented) throws JsonProcessingException;
    public void occurReturnEvent(ItemReturned itemReturned) throws JsonProcessingException;
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException;
}

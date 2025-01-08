package org.msa.service.book.adaptor.in.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.msa.service.book.application.port.in.MakeAvailableService;
import org.msa.service.book.application.port.in.MakeUnAvailableService;
import org.msa.service.book.domain.event.ItemRented;
import org.msa.service.book.domain.event.ItemReturned;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookEventConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MakeAvailableService makeAvailableService;
    private final MakeUnAvailableService makeUnAvailableService;

    @KafkaListener(topics = "${consumer.topic1.name}", groupId = "${consumer.groupid.name}")
    public void consumeRental(ConsumerRecord<String, String> record) throws IOException {
        System.out.println("rental_rent: " + record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        makeUnAvailableService.unAvailable(itemRented.getItem().getNo());
    }

    @KafkaListener(topics = "${consumer.topic2.name}", groupId = "${consumer.groupid.name}")
    public void consumeReturn(ConsumerRecord<String, String> record) throws IOException {
        System.out.println("rental_return: " + record.value());
        ItemReturned itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
        makeAvailableService.available(itemReturned.getItem().getNo());
    }
}

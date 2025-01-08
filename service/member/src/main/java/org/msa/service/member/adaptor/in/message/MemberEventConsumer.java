package org.msa.service.member.adaptor.in.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.msa.service.member.application.port.in.SavePointService;
import org.msa.service.member.application.port.in.UsePointService;
import org.msa.service.member.domain.event.ItemRented;
import org.msa.service.member.domain.event.ItemReturned;
import org.msa.service.member.domain.event.OverdueCleared;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemberEventConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final SavePointService savePointService;
    private final UsePointService usePointService;

    @KafkaListener(topics = "${consumer.topic1.name}", groupId = "${consumer.groupid.name}")
    public void consumeRent(ConsumerRecord<String, String> record) throws IOException {
        log.info("rental_rent: " + record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        savePointService.savePoint(itemRented.getIdName(), itemRented.getPoint());
    }

    @KafkaListener(topics = "${consumer.topic2.name}", groupId = "${consumer.groupid.name}")
    public void consumeReturn(ConsumerRecord<String, String> record) throws IOException {
        log.info("rental_return: " + record.value());
        ItemRented itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
        savePointService.savePoint(itemReturned.getIdName(), itemReturned.getPoint());
    }

    @KafkaListener(topics = "${consumer.topic3.name}", groupId = "${consumer.groupid.name}")
    public void consumeClear(ConsumerRecord<String, String> record) throws Exception {
        log.info("overdue_clear: " + record.value());
        OverdueCleared overdueCleared = objectMapper.readValue(record.value(), OverdueCleared.class);
        usePointService.usePoint(overdueCleared.getIdName(), overdueCleared.getPoint());
    }
}

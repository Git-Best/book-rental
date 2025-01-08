package org.msa.service.rental.adaptor.out.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msa.service.rental.application.port.out.EventPort;
import org.msa.service.rental.domain.event.ItemRented;
import org.msa.service.rental.domain.event.ItemReturned;
import org.msa.service.rental.domain.event.OverdueCleared;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RentalProducer implements EventPort {

    @Value("${producers.topic1.name}")
    private String TOPIC_RENT;

    @Value("${producers.topic2.name}")
    private String TOPIC_RETURN;

    @Value("${producers.topic3.name}")
    private String TOPIC_CLEAR;

    private final KafkaTemplate<String, ItemRented> kafkaTemplate1;
    private final KafkaTemplate<String, ItemReturned> kafkaTemplate2;
    private final KafkaTemplate<String, OverdueCleared> kafkaTemplate3;

    @Override
    public void occurRentEvent(ItemRented itemRented) throws JsonProcessingException {
        CompletableFuture<SendResult<String, ItemRented>> future = kafkaTemplate1.send(TOPIC_RENT, itemRented);
        future.thenAccept(result -> {
            ItemRented value = result.getProducerRecord().value();
            log.info("Sent message=[" + value.getItem().getNo() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }).exceptionally(ex -> {
            log.error("Unable to send message=[" + itemRented.getItem().getNo() + "] due to : " + ex.getMessage(), ex);
            return null;
        });
    }

    @Override
    public void occurReturnEvent(ItemReturned itemReturned) throws JsonProcessingException {
        CompletableFuture<SendResult<String, ItemReturned>> future = kafkaTemplate2.send(TOPIC_RETURN, itemReturned);
        future.thenAccept(result -> {
            ItemRented value = result.getProducerRecord().value();
            log.info("Sent message=[" + value.getItem().getNo() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }).exceptionally(ex -> {
            log.error("Unable to send message=[" + itemReturned.getItem().getNo() + "] due to : " + ex.getMessage(), ex);
            return null;
        });
    }

    @Override
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException {
        CompletableFuture<SendResult<String, OverdueCleared>> future = kafkaTemplate3.send(TOPIC_CLEAR, overdueCleared);
        future.thenAccept(result -> {
            OverdueCleared value = result.getProducerRecord().value();
            log.info("Sent message=[" + value.getIdName().getId() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }).exceptionally(ex -> {
            log.error("Unable to send message=[" + overdueCleared.getIdName().getId() + "] due to : " + ex.getMessage(), ex);
            return null;
        });
    }
}

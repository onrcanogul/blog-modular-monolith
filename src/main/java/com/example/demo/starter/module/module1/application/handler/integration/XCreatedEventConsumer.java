package com.example.demo.starter.module.module1.application.handler.integration;

import com.example.demo.starter.shared.kernel.event.integration.IdempotencyStore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class XCreatedEventConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final IdempotencyStore idempotencyStore;

    public XCreatedEventConsumer(IdempotencyStore store) {
        this.idempotencyStore = store;
    }

    @KafkaListener(topics = "module1.created", groupId = "auth-service")
    public void consume(String payload, Acknowledgment ack) throws Exception {

        /*
        XCreatedEvent event = objectMapper.readValue(payload, XCreatedEvent.class);

         if (idempotencyStore.exists(event.getIdempotencyKey())) {
            ack.acknowledge();
            return;
        }
        handleEvent(event);
        idempotencyStore.save(event.getIdempotencyKey());
         */
        ack.acknowledge();
    }

        /*    private void handleEvent(Module1CreatedIntegrationEvent event) {
            System.out.println("Auth consumed: " + event);
            }

        */
}




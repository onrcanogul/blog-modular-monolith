package com.example.demo.starter.shared.infrastructure.kafka;

import com.example.demo.starter.shared.kernel.event.integration.IntegrationEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIntegrationPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaIntegrationPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void publish(IntegrationEvent event) {
        try {
            String payload = objectMapper.writeValueAsString(event);
            kafkaTemplate.send(event.topicName(), event.getIdempotencyKey().toString(), payload);
        } catch (Exception e) {
            throw new RuntimeException("Failed to publish integration event.", e);
        }
    }
}

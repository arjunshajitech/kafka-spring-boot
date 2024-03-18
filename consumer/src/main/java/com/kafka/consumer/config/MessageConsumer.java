package com.kafka.consumer.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "study_kafka", groupId = "tech_1")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}

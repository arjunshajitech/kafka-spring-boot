package com.kafka.producer.controller;

import com.kafka.producer.config.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class KafkaController {

    final MessageProducer messageProducer;
    public static String KAFKA_TOPIC = "study_kafka";

    public KafkaController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage() throws InterruptedException {

        int i = 0;
        while (i < 100) {
            String message = "######## " + UUID.randomUUID() + " #######";
            messageProducer.sendMessage(KAFKA_TOPIC, message);
            i++;
        }
        return ResponseEntity.status(200).body(Map.of("message","completed."));
    }
}

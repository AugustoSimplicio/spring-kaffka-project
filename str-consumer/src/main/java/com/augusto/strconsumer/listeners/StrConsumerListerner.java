package com.augusto.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListerner {

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "stringConfigKafkaListenerContainerFactory")
    public void listen(String message) {
        log.info("Receive message {}", message);
    }
}

package com.augusto.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListerner {

    @KafkaListener(groupId = "group-o", topics = "str-topic", containerFactory = "stringConfigKafkaListenerContainerFactory")
    public void create(String message) {
        log.info("CREATE ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "stringConfigKafkaListenerContainerFactory")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "stringConfigKafkaListenerContainerFactory")
    public void test(String message) {
        log.info("LOG ::: Receive message {}", message);
    }
}

package com.augusto.strconsumer.listeners;

import com.augusto.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListerner {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("CREATE ::: Receive message {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(topics = "str-topic", groupId = "2", containerFactory = "validMessageContainerFactorry")
    public void test(String message) {
        log.info("LOG ::: Receive message {}", message);
    }
}

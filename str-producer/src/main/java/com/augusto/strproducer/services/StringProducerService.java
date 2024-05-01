package com.augusto.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                        if (success != null) {
                            log.info("Mensagem enviada com sucesso {}", message);
                            log.info("Partition {}, Offset {}",
                                    success.getRecordMetadata().partition(),
                                    success.getRecordMetadata().offset());
                        }

                    },
                err -> log.error("Erro ao enviar mensagem", err)
        );
    }
}

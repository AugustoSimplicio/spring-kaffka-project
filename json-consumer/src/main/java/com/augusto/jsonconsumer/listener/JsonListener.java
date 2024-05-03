package com.augusto.jsonconsumer.listener;

import com.augusto.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonListenerContainerFactory")
    public void antiFraude(@Payload Payment payment){
        log.info("validando ::: Anti Fraude Topic", payment.toString());
        Thread.sleep(2000);

        log.info("validando ::: Anti Fraude Topic");

        Thread.sleep(3000);

    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonListenerContainerFactory")
    public void pdfGenerator(){
        log.info("Gerando pdf ....");
        Thread.sleep(2000);

    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonListenerContainerFactory")
    public void sendEmail(){
        log.info("Enviado email de confirmação ....");
        Thread.sleep(2000);

    }
}

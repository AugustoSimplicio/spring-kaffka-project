package com.augusto.paymentservice.service.impl;

import com.augusto.paymentservice.model.Payment;
import com.augusto.paymentservice.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL | Recebi o pagamento {}", payment);
        Thread.sleep(1000);

        log.info("Enviado pagamento ...");
        kafkaTemplate.send("payment-topic", payment);
    }
}

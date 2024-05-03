package com.augusto.paymentservice.service.impl;

import com.augusto.paymentservice.model.Payment;
import com.augusto.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL | Recebi o pagamento {}", payment);
    }
}

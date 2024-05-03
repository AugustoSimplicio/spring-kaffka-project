package com.augusto.paymentservice.service;

import com.augusto.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}

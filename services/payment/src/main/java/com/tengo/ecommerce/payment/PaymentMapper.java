package com.tengo.ecommerce.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment ToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(paymentRequest.id())
                .orderId(paymentRequest.orderId())
                .paymentMethod(paymentRequest.paymentMethod())
                .amount(paymentRequest.amount())
                .build();
    }
}

package com.tengo.ecommerce.payment;

import com.tengo.ecommerce.customer.CustomerResponse;
import com.tengo.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}


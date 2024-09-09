package com.tengo.ecommerce.kafka;

import com.tengo.ecommerce.customer.CustomerResponse;
import com.tengo.ecommerce.order.PaymentMethod;
import com.tengo.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}

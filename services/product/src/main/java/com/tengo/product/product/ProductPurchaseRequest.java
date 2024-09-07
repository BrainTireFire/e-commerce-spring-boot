package com.tengo.product.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "Product id is required")
        Integer productId,
        @NotNull(message = "Product quantity is required")
        @Positive(message = "Product quantity must be greater than 0")
        double quantity
) {
}

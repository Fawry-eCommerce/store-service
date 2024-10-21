package com.fawry.store.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record StockDto(
        Long id,
        @NotNull(message = "Store id is required")
        Long storeId,
        @NotNull(message = "Product id is required")
        Long productId,
        @Digits(integer = 10, fraction = 0, message = "Quantity must be a number")
        @NotNull(message = "Quantity is required")
        Long quantity
) {
}

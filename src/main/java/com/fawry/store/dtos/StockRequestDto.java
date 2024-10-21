package com.fawry.store.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public record StockRequestDto(
        @Digits(integer = 10, fraction = 0, message = "Quantity must be a number")
        @NotNull(message = "Quantity is required")
        Long quantity
) {
}

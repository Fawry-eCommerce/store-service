package com.fawry.store.dtos;

import lombok.Builder;

@Builder
public record ConsumptionRequestDto(
        Long storeId,
        Long productId,
        int quantity,
        String consumerEmail
) {
}

package com.fawry.store.dtos;

import lombok.Builder;

@Builder
public record StockDto(
        Long id,
        Long storeId,
        Long productId,
        Long quantity
) {
}

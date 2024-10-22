package com.fawry.store.dtos;

import lombok.Builder;

@Builder
public record ProductDto(
        Long id,
        String name,
        String sku,
        String code,
        double price,
        String imageUrl,
        String description,
        String categoryModel
) {
}

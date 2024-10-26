package com.fawry.store.dtos;

import lombok.Builder;

@Builder
public record ProductDto(
        Long id,
        String name,
        String sku,
        String code,
        double price,
        String imageURL,
        String description,
        CategoryDto categoryModel,
        int stockQuantity
) {
}

package com.fawry.store.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record StoreDto(
        Long storeId,
        @NotBlank(message = "Store name required.")
        String name,
        @NotBlank(message = "Store location required.")
        String location
) {
}

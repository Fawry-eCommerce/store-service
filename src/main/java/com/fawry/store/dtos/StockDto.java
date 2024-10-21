package com.fawry.store.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDto {
    private Long id;
    @NotNull(message = "Store ID is required")
    private Long storeId;
    @NotNull(message = "Product ID is required")
    private Long productId;
    @NotNull(message = "Quantity is required")
    private int quantity;
}

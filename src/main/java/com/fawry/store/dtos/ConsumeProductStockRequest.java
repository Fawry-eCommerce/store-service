package com.fawry.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsumeProductStockRequest {
    private Long productId;
    private Long storeId;
    private int quantity;
}
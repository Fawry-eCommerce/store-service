package com.fawry.store.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsumeProductStockResponse {
    private String code;
    private int availableQuantity;
    private boolean isAvailable;
}
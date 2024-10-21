package com.fawry.store.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreHistoryDto {
    private Long id;
    private Long productId;
    private Long storeId;
    private int quantityChanged;
    private String consumerEmail;
    private String actionType;
    private String createdAt;
}

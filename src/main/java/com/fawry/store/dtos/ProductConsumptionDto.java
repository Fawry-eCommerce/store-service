package com.fawry.store.dtos;

import com.fawry.store.entities.Store;
import com.fawry.store.enums.StoreActionType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductConsumptionDto {
    private Long id;
    private Long productId;
    private Store store;
    private int quantityChanged;
    private StoreActionType actionType;
    private String consumerEmail;
    private LocalDateTime createdAt;
}

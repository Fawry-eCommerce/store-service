package com.fawry.store.services.consmption;

import com.fawry.store.dtos.ConsumptionRequestDto;
import com.fawry.store.dtos.StoreHistoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ConsumptionService {
    void consumeProduct(ConsumptionRequestDto consumptionRequestDto);
    void addProductConsumption(ConsumptionRequestDto consumptionRequestDto);
    Page<StoreHistoryDto> getAllProductConsumptions(Pageable pageable);
    Page<StoreHistoryDto> getProductConsumptionByStoreId(Pageable pageable, Long storeId);
    Page<StoreHistoryDto> getStockHistoryForProduct(Pageable pageable, Long productId, Long storeId);
}

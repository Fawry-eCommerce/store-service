package com.fawry.store.services.consmption;

import com.fawry.store.dtos.ProductConsumptionDto;
import com.fawry.store.entities.StoreHistory;

import java.util.List;

public interface ConsumptionService {
    void consumeProduct(StoreHistory storeHistory);
    List<ProductConsumptionDto> getAllProductConsumptions();
    List<ProductConsumptionDto> getProductConsumptionByStoreId(Long storeId);
    ProductConsumptionDto getProductConsumptionFromStore(Long productId, Long storeId);
}

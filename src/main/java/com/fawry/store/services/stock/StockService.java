package com.fawry.store.services.stock;

import com.fawry.store.dtos.ConsumptionRequestDto;
import com.fawry.store.dtos.StockDto;
import com.fawry.store.entities.Stock;

public interface StockService {
    void saveStock(Stock stock);
    StockDto addProductToStock(String consumerEmail, StockDto stockDto);
    void consumeProduct(ConsumptionRequestDto consumptionRequestDto);
    void checkProductStock(Long productId, Long storeId, int quantity);
    Stock getStockByProductIdAndStoreId(Long productId, Long storeId);
}

package com.fawry.store.services.stock;

import com.fawry.store.dtos.StockDto;
import com.fawry.store.dtos.StockRequestDto;

public interface StockService {
    StockDto addProductToStock(Long storeId, Long productId, StockRequestDto stockDto);
}

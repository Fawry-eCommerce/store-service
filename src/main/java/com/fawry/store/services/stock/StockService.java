package com.fawry.store.services.stock;

import com.fawry.store.dtos.StockDto;

public interface StockService {
    StockDto addProductToStock(StockDto stockDto);
}

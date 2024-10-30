package com.fawry.store.services.stock;

import com.fawry.store.dtos.ConsumptionRequestDto;
import com.fawry.store.dtos.ProductDto;
import com.fawry.store.dtos.StockDto;
import com.fawry.store.entities.Stock;

import java.util.List;

public interface StockService {
    void saveStock(Stock stock);
    StockDto addProductToStock(String consumerEmail, StockDto stockDto);
    void consumeProduct(ConsumptionRequestDto consumptionRequestDto);
    void checkProductStock(Long productId, Long storeId, int quantity);
    Stock getStockByProductIdAndStoreId(Long productId, Long storeId);
    List<ProductDto> searchProducts(Long storeId, String name, String category, String code);
    boolean isStockExistsByStoreIdAndProductId(Long storeId, Long productId);
    void checkoutProductsOutOfStock(List<StockDto> stocks);
}

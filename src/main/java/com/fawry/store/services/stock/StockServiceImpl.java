package com.fawry.store.services.stock;

import com.fawry.store.clients.productclient.ProductClient;
import com.fawry.store.dtos.StockDto;
import com.fawry.store.entities.Stock;
import com.fawry.store.entities.Store;
import com.fawry.store.entities.StoreHistory;
import com.fawry.store.enums.StoreActionType;
import com.fawry.store.mappers.StockMapper;
import com.fawry.store.repositories.StockRepository;
import com.fawry.store.services.consmption.ConsumptionService;
import com.fawry.store.services.store.StoreService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final StoreService storeService;
    private final ProductClient productClient;
    private final StockMapper stockMapper;
    private final ConsumptionService consumptionService;

    @Override
    @Transactional
    public StockDto addProductToStock(StockDto stockDto) {
        validateProductExists(stockDto.productId());
        Store store = storeService.getStoreById(stockDto.storeId());
        Stock stock = stockRepository.findByProductIdAndStoreId(stockDto.productId(), stockDto.storeId());
        if (stock != null) {
            stock.setQuantity(stock.getQuantity() + stockDto.quantity());
            stock = stockRepository.save(stock);
        } else {
            stock = stockRepository.save(stockMapper.toEntity(0L, stockDto.quantity(), stockDto.productId(), store));
        }
        recordConsumption(stock.getProductId(), stock.getQuantity(), store);
        return stockMapper.toDto(stock);
    }

    private void validateProductExists(Long productId) {
        boolean isProductExists = productClient.checkProductExists(productId);
        if (!isProductExists) {
            throw new EntityNotFoundException("Product does not exist");
        }
    }

    private void recordConsumption(Long productId, int quantity, Store store) {
        consumptionService.consumeProduct(
                StoreHistory.builder()
                        .productId(productId)
                        .store(store)
                        .quantityChanged(quantity)
                        .actionType(StoreActionType.ADD)
                        .consumerEmail("kortam@gmail.com") // TODO: get from logged in admin user
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}

package com.fawry.store.services.stock;

import com.fawry.store.clients.ProductClient;
import com.fawry.store.dtos.ConsumptionRequestDto;
import com.fawry.store.dtos.ProductDto;
import com.fawry.store.dtos.StockDto;
import com.fawry.store.entities.Stock;
import com.fawry.store.entities.Store;
import com.fawry.store.enums.Messages;
import com.fawry.store.mappers.StockMapper;
import com.fawry.store.repositories.StockRepository;
import com.fawry.store.services.consmption.ConsumptionService;
import com.fawry.store.services.store.StoreService;
import com.fawry.store.utils.StockUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final StoreService storeService;
    private final ProductClient productClient;
    private final StockMapper stockMapper;
    private final ConsumptionService consumptionService;

    @Override
    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    @Transactional
    public StockDto addProductToStock(String consumerEmail, StockDto stockDto) {
        validateProductExists(stockDto.getProductId());
        Store store = storeService.getStore(stockDto.getStoreId());
        Stock stock = stockRepository.findByProductIdAndStoreId(stockDto.getProductId(), stockDto.getStoreId());
        if (stock == null) {
            stock = stockMapper.toEntity(stockDto, store);
        } else {
            stock.setQuantity(stock.getQuantity() + stockDto.getQuantity());
        }
        stock = stockRepository.save(stock);
        consumptionService.addProductConsumption(
                ConsumptionRequestDto.builder()
                        .storeId(store.getId())
                        .productId(stock.getProductId())
                        .quantity(stock.getQuantity())
                        .consumerEmail(consumerEmail)
                        .build()
        );
        return stockMapper.toDto(stock);
    }

    @Override
    public void checkProductStock(Long productId, Long storeId, int quantity) {
        Stock stock = stockRepository.findByProductIdAndStoreId(productId, storeId);
        StockUtils.validateStock(stock, quantity);
    }

    @Override
    @Transactional
    public void consumeProduct(ConsumptionRequestDto consumptionRequestDto) {
        checkProductStock(
                consumptionRequestDto.productId(),
                consumptionRequestDto.storeId(),
                consumptionRequestDto.quantity()
        );
        Stock stock = getStockByProductIdAndStoreId(consumptionRequestDto.productId(), consumptionRequestDto.storeId());
        stock.setQuantity(stock.getQuantity() - consumptionRequestDto.quantity());
        saveStock(stock);

        consumptionService.consumeProduct(consumptionRequestDto);
    }

    @Override
    public Stock getStockByProductIdAndStoreId(Long productId, Long storeId) {
        return stockRepository.findByProductIdAndStoreId(productId, storeId);
    }

    @Override
    public List<ProductDto> searchProducts(Long storeId, String name, String category, String code) {
        Store store = storeService.getStore(storeId);
        Set<Long> productIds = store.getStocks().stream()
                .map(Stock::getProductId)
                .collect(Collectors.toSet());

        List<ProductDto> productsPage = productClient.searchProducts(name, category, code);

        return productsPage.stream()
                .filter(product -> productIds.contains(product.id()))
                .filter((product) -> product.name().contains(name) && product.code().contains(code))
                .map(product -> {
                    Stock stock = getStockByProductIdAndStoreId(product.id(), storeId);
                    return new ProductDto(
                            product.id(),
                            product.name(),
                            product.sku(),
                            product.code(),
                            product.price(),
                            product.imageURL(),
                            product.description(),
                            product.categoryModel(),
                            stock.getQuantity()
                    );
                }).toList();
    }

    @Override
    public boolean isStockExistsByStoreIdAndProductId(Long storeId, Long productId) {
        return stockRepository.existsByStoreIdAndProductId(storeId, productId);
    }

    private void validateProductExists(Long productId) {
        boolean isProductExists = productClient.checkProductExists(productId);
        if (!isProductExists) {
            throw new EntityNotFoundException(Messages.PRODUCT_NOT_FOUND.getMessage());
        }
    }

}

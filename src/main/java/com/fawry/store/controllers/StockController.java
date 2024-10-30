package com.fawry.store.controllers;

import com.fawry.store.dtos.ConsumptionRequestDto;
import com.fawry.store.dtos.ProductDto;
import com.fawry.store.dtos.StockDto;
import com.fawry.store.services.stock.StockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDto addStockToProduct(@RequestHeader String consumerEmail, @Valid @RequestBody StockDto stockDto) {
        return stockService.addProductToStock(consumerEmail, stockDto);
    }

    @PostMapping("consume")
    public void consumeProduct(@RequestBody ConsumptionRequestDto consumptionRequestDto) {
        stockService.consumeProduct(consumptionRequestDto);
    }

    @PostMapping("validate")
    public void validateStock(@Valid @RequestBody StockDto stockDto) {
        stockService.checkProductStock(stockDto.getProductId(), stockDto.getStoreId(), stockDto.getQuantity());
    }

    @GetMapping("search-products")
    public List<ProductDto> searchProducts(@RequestParam(defaultValue = "") Long storeId,
                                           @RequestParam(defaultValue = "") String name,
                                           @RequestParam(defaultValue = "") String category,
                                           @RequestParam(defaultValue = "") String code) {
        return stockService.searchProducts(storeId, name, category, code);
    }

}

package com.fawry.store.controllers;

import com.fawry.store.dtos.StockDto;
import com.fawry.store.dtos.StockRequestDto;
import com.fawry.store.dtos.StoreDto;
import com.fawry.store.entities.Store;
import com.fawry.store.services.stock.StockService;
import com.fawry.store.services.store.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store createStore(@Valid @RequestBody StoreDto store) {
        return storeService.createStore(store);
    }

    @PostMapping("/{storeId}/products/{productId}/stock")
    @ResponseStatus(HttpStatus.CREATED)
    public StockDto addStockToProduct(@PathVariable Long storeId, @PathVariable Long productId, @Valid @RequestBody StockRequestDto stockDto) {
        return stockService.addProductToStock(storeId, productId, stockDto);
    }

}

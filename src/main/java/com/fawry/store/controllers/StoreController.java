package com.fawry.store.controllers;

import com.fawry.store.dtos.StockDto;
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

    @PostMapping("add-stock")
    public StockDto addStockToProduct(@Valid @RequestBody StockDto stockDto) {
        return stockService.addProductToStock(stockDto);
    }

}

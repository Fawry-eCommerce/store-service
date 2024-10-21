package com.fawry.store.controllers;

import com.fawry.store.dtos.StockDto;
import com.fawry.store.services.stock.StockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDto addStockToProduct(@Valid @RequestBody StockDto stockDto) {
        return stockService.addProductToStock(stockDto);
    }

}

package com.fawry.store.controllers;

import com.fawry.store.dtos.StoreHistoryDto;
import com.fawry.store.services.consmption.ConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("consumptions")
@RequiredArgsConstructor
public class ConsumptionController {

    private final ConsumptionService consumptionService;

    @GetMapping
    public Page<StoreHistoryDto> getAllProductConsumptions(Pageable pageable) {
        return consumptionService.getAllProductConsumptions(pageable);
    }

    @GetMapping("{storeId}")
    public Page<StoreHistoryDto> getProductConsumptionByStoreId(Pageable pageable, @PathVariable Long storeId) {
        return consumptionService.getProductConsumptionByStoreId(pageable, storeId);
    }

    @GetMapping("{storeId}/products/{productId}/history")
    public Page<StoreHistoryDto> getStockHistoryForProduct(Pageable pageable, @PathVariable Long storeId, @PathVariable Long productId) {
        return consumptionService.getStockHistoryForProduct(pageable, productId, storeId);
    }

}

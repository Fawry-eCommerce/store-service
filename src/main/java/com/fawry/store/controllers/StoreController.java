package com.fawry.store.controllers;

import com.fawry.store.dtos.ProductConsumptionDto;
import com.fawry.store.dtos.StoreDto;
import com.fawry.store.entities.Store;
import com.fawry.store.services.consmption.ConsumptionService;
import com.fawry.store.services.store.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final ConsumptionService consumptionService;

    @GetMapping
    public List<StoreDto> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store createStore(@Valid @RequestBody StoreDto store) {
        return storeService.createStore(store);
    }

    @GetMapping("/{storeId}/products/{productId}/history")
    public ProductConsumptionDto getProductStockHistory(@PathVariable Long storeId, @PathVariable Long productId) {
        return consumptionService.getProductConsumptionFromStore(storeId, productId);
    }

    // TODO: handle product search feature

}

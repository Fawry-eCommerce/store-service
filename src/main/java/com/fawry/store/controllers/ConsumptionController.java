package com.fawry.store.controllers;

import com.fawry.store.dtos.ProductConsumptionDto;
import com.fawry.store.services.consmption.ConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumptions")
@RequiredArgsConstructor
public class ConsumptionController {

    private final ConsumptionService consumptionService;

    @GetMapping
    public List<ProductConsumptionDto> getAllProductConsumptions() {
        return consumptionService.getAllProductConsumptions();
    }

    @GetMapping("/{storeId}")
    public List<ProductConsumptionDto> getProductConsumptionByStoreId(@PathVariable Long storeId) {
        return consumptionService.getProductConsumptionByStoreId(storeId);
    }

}

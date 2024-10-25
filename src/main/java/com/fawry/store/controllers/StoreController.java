package com.fawry.store.controllers;

import com.fawry.store.dtos.StoreDto;
import com.fawry.store.services.store.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public Page<StoreDto> getAllStores(Pageable pageable) {
        return storeService.getAllStores(pageable);
    }

    @GetMapping("{id}")
    public StoreDto getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoreDto createStore(@Valid @RequestBody StoreDto store) {
        return storeService.createStore(store);
    }

    @PutMapping("{id}")
    public StoreDto updateStore(@PathVariable Long id, @Valid @RequestBody StoreDto store) {
        return storeService.updateStore(id, store);
    }

    @DeleteMapping("{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }

}

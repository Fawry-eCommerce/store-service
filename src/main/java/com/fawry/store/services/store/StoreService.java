package com.fawry.store.services.store;

import com.fawry.store.dtos.ProductDto;
import com.fawry.store.dtos.StoreDto;
import com.fawry.store.entities.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface StoreService {
    Page<StoreDto> getAllStores(Pageable pageable);
    Store getStore(Long id);
    StoreDto getStoreById(Long id);
    StoreDto createStore(Store store);
    StoreDto updateStore(Long id, Store store);
    void deleteStore(Long id);
    boolean checkStoreExists(String name, String location);
    Page<ProductDto> searchProducts(Long storeId, String name, String category, Pageable pageable);
}

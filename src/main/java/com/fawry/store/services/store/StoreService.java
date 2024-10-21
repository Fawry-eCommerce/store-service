package com.fawry.store.services.store;

import com.fawry.store.dtos.StoreDto;
import com.fawry.store.entities.Store;

public interface StoreService {
    Store getStoreById(Long id);
    Store getStoreByName(String name);
    Store createStore(StoreDto store);
    boolean checkStoreExists(String name, String location);
}

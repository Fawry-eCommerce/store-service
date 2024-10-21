package com.fawry.store.services.store;

import com.fawry.store.dtos.StoreDto;
import com.fawry.store.entities.Store;
import com.fawry.store.mappers.StoreMapper;
import com.fawry.store.repositories.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Store not found")
        );
    }

    @Override
    public Store getStoreByName(String name) {
        return storeRepository.getStoreByName(name).orElseThrow(
                () -> new EntityNotFoundException("Store not found")
        );
    }

    @Override
    public Store createStore(StoreDto store) {
        boolean isStoreExists = checkStoreExists(store.name(), store.location());
        if (isStoreExists) {
            throw new EntityNotFoundException("Store already exists");
        }
        Store newStore = storeMapper.toEntity(store);
        return storeRepository.save(newStore);
    }

    @Override
    public boolean checkStoreExists(String name, String location) {
        return storeRepository.existsByNameAndLocation(name, location);
    }

}

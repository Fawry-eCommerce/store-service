package com.fawry.store.services.store;

import com.fawry.store.enums.Messages;
import com.fawry.store.dtos.StoreDto;
import com.fawry.store.entities.Store;
import com.fawry.store.mappers.StoreMapper;
import com.fawry.store.repositories.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Override
    public Page<StoreDto> getAllStores(Pageable pageable) {
        return storeRepository.findAll(pageable).map(storeMapper::toDto);
    }

    @Override
    public Store getStore(Long id) {
        return storeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Messages.STORE_NOT_FOUND.getMessage())
        );
    }

    @Override
    public StoreDto getStoreById(Long id) {
        return storeMapper.toDto(getStore(id));
    }

    @Override
    public StoreDto createStore(StoreDto store) {
        if (checkStoreExists(store.getName(), store.getLocation())) {
            throw new IllegalArgumentException(Messages.STORE_ALREADY_EXISTS.getMessage());
        }
        Store newStore = storeMapper.toEntity(store);
        return storeMapper.toDto(storeRepository.save(newStore));
    }

    @Override
    public StoreDto updateStore(Long id, StoreDto store) {
        Store existingStore = getStore(id);
        updateStoreDetails(existingStore, store);
        return storeMapper.toDto(storeRepository.save(existingStore));
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.delete(getStore(id));
    }

    @Override
    public boolean checkStoreExists(String name, String location) {
        return storeRepository.existsByNameAndLocation(name, location);
    }

    private void updateStoreDetails(Store existingStore, StoreDto store) {
        existingStore.setName(store.getName());
        existingStore.setLocation(store.getLocation());
    }
}

package com.fawry.store.services.store;

import com.fawry.store.clients.ProductClient;
import com.fawry.store.dtos.ProductDto;
import com.fawry.store.entities.Stock;
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

import java.util.List;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;
    private final ProductClient productClient;

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
    public StoreDto createStore(Store store) {
        boolean isStoreExists = checkStoreExists(store.getName(), store.getLocation());
        if (isStoreExists) {
            throw new IllegalArgumentException(Messages.STORE_ALREADY_EXISTS.getMessage());
        }
        return storeMapper.toDto(storeRepository.save(store));
    }

    @Override
    public StoreDto updateStore(Long id, Store store) {
        Store existingStore = getStore(id);
        existingStore.setName(store.getName());
        existingStore.setLocation(store.getLocation());
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

    @Override
    public Page<ProductDto> searchProducts(Long storeId, String name, String category, Pageable pageable) {
        Store store = getStore(storeId);
        List<Long> productIds = store.getStocks().stream()
                .map(Stock::getProductId)
                .toList();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), productIds.size());
        List<Long> pagedProductIds = productIds.subList(start, end);

        return productClient.getProductsByIds(pagedProductIds, pageable);
    }

}

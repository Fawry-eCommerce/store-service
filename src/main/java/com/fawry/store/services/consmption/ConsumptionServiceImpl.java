package com.fawry.store.services.consmption;

import com.fawry.store.dtos.ProductConsumptionDto;
import com.fawry.store.entities.StoreHistory;
import com.fawry.store.mappers.ConsumptionMapper;
import com.fawry.store.repositories.StoreHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumptionServiceImpl implements ConsumptionService {

    private final StoreHistoryRepository storeHistoryRepository;
    private final ConsumptionMapper consumptionMapper;

    @Override
    public void consumeProduct(StoreHistory storeHistory) {
        storeHistoryRepository.save(storeHistory);
    }

    @Override
    public List<ProductConsumptionDto> getAllProductConsumptions() {
        return storeHistoryRepository.findAll()
                .stream()
                .map(consumptionMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductConsumptionDto> getProductConsumptionByStoreId(Long storeId) {
        return storeHistoryRepository.getStoreHistoriesByStoreId(storeId)
                .stream()
                .map(consumptionMapper::toDto)
                .toList();
    }

    @Override
    public ProductConsumptionDto getProductConsumptionFromStore(Long productId, Long storeId) {
        return consumptionMapper.toDto(
                storeHistoryRepository.getStoreHistoryByProductIdAndStoreId(productId, storeId)
        );
    }
}

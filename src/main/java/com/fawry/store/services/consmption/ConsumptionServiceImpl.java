package com.fawry.store.services.consmption;

import com.fawry.store.dtos.ConsumptionRequestDto;
import com.fawry.store.dtos.StoreHistoryDto;
import com.fawry.store.entities.StoreHistory;
import com.fawry.store.enums.StoreActionType;
import com.fawry.store.mappers.ConsumptionMapper;
import com.fawry.store.repositories.StoreHistoryRepository;
import com.fawry.store.services.store.StoreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class ConsumptionServiceImpl implements ConsumptionService {

    private final StoreHistoryRepository storeHistoryRepository;
    private final StoreService storeService;
    private final ConsumptionMapper consumptionMapper;

    @Override
    @Transactional
    public void consumeProduct(ConsumptionRequestDto consumptionRequestDto) {
        recordConsumption(consumptionRequestDto, StoreActionType.CONSUME);
    }

    @Override
    public void addProductConsumption(ConsumptionRequestDto consumptionRequestDto) {
        recordConsumption(consumptionRequestDto, StoreActionType.ADD);
    }

    @Override
    public Page<StoreHistoryDto> getAllProductConsumptions(Pageable pageable) {
        return storeHistoryRepository.findAll(pageable)
                .map(consumptionMapper::toDto);
    }

    @Override
    public Page<StoreHistoryDto> getProductConsumptionByStoreId(Pageable pageable, Long storeId) {
        return storeHistoryRepository.getStoreHistoriesByStoreId(pageable, storeId)
                .map(consumptionMapper::toDto);
    }

    @Override
    public Page<StoreHistoryDto> getStockHistoryForProduct(Pageable pageable, Long productId, Long storeId) {
        return storeHistoryRepository.getStoreHistoryByProductIdAndStoreId(pageable, productId, storeId)
                .map(consumptionMapper::toDto);
    }

    private void recordConsumption(ConsumptionRequestDto consumptionRequestDto, StoreActionType actionType) {
        storeHistoryRepository.save(
                StoreHistory.builder()
                        .productId(consumptionRequestDto.productId())
                        .store(storeService.getStore(consumptionRequestDto.storeId()))
                        .quantityChanged(consumptionRequestDto.quantity())
                        .consumerEmail(consumptionRequestDto.consumerEmail())
                        .actionType(actionType)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}

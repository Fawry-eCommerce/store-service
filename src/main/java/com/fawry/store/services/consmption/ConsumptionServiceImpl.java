package com.fawry.store.services.consmption;

import com.fawry.store.entities.StoreHistory;
import com.fawry.store.repositories.StoreHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumptionServiceImpl implements ConsumptionService {

    private final StoreHistoryRepository storeHistoryRepository;

    @Override
    public void consumeProduct(StoreHistory storeHistory) {
        storeHistoryRepository.save(storeHistory);
    }
}

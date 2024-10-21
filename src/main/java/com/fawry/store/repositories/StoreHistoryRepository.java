package com.fawry.store.repositories;

import com.fawry.store.entities.StoreHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreHistoryRepository extends JpaRepository<StoreHistory, Long> {
    List<StoreHistory> getStoreHistoriesByStoreId(Long storeId);
    StoreHistory getStoreHistoryByProductIdAndStoreId(Long productId, Long storeId);
}

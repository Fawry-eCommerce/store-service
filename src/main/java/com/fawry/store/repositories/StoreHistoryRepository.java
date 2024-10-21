package com.fawry.store.repositories;

import com.fawry.store.entities.StoreHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreHistoryRepository extends JpaRepository<StoreHistory, Long> {
    Page<StoreHistory> getStoreHistoriesByStoreId(Pageable pageable, Long storeId);
    Page<StoreHistory> getStoreHistoryByProductIdAndStoreId(Pageable pageable, Long productId, Long storeId);
}

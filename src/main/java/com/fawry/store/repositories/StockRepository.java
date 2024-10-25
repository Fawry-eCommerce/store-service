package com.fawry.store.repositories;

import com.fawry.store.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByProductIdAndStoreId(Long productId, Long storeId);
    boolean existsByStoreIdAndProductId(Long storeId, Long productId);
}

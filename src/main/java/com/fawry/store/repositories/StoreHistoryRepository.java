package com.fawry.store.repositories;

import com.fawry.store.entities.StoreHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreHistoryRepository extends JpaRepository<StoreHistory, Long> {
}

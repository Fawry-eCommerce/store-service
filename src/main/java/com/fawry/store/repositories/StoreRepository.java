package com.fawry.store.repositories;

import com.fawry.store.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsByNameAndLocation(String name, String location);
}

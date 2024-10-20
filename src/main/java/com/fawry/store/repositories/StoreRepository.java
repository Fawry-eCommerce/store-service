package com.fawry.store.repositories;

import com.fawry.store.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> getStoreByName(String name);
    boolean existsByNameAndLocation(String name, String location);
}

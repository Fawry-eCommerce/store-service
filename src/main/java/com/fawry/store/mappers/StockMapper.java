package com.fawry.store.mappers;

import com.fawry.store.dtos.StockDto;
import com.fawry.store.entities.Stock;
import com.fawry.store.entities.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "store", source = "store")
    @Mapping(target = "productId", source = "productId")
    Stock toEntity(Long id, Long productId, Store store);
    @Mapping(target = "storeId", source = "store.id")
    StockDto toDto(Stock entity);
}

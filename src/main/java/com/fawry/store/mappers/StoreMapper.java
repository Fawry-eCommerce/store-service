package com.fawry.store.mappers;

import com.fawry.store.dtos.StoreDto;
import com.fawry.store.entities.Store;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    Store toEntity(StoreDto storeDto);
    StoreDto toDto(Store store);
}

package com.fawry.store.mappers;

import com.fawry.store.dtos.StoreHistoryDto;
import com.fawry.store.entities.StoreHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsumptionMapper {
    @Mapping(target = "storeId", source = "store.id")
    StoreHistoryDto toDto(StoreHistory storeHistory);
}

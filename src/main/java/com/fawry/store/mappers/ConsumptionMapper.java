package com.fawry.store.mappers;

import com.fawry.store.dtos.ProductConsumptionDto;
import com.fawry.store.entities.StoreHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsumptionMapper {
    ProductConsumptionDto toDto(StoreHistory storeHistory);
}

package com.fawry.store.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreDto {
    private Long id;
    private String name;
    private String location;
}

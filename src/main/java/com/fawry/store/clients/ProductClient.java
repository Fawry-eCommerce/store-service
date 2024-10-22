package com.fawry.store.clients;


import com.fawry.store.dtos.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//@FeignClient(name = "product-service")
public interface ProductClient {
    boolean checkProductExists(Long productId);
    Page<ProductDto> getProductsByIds(List<Long> productIds, Pageable pageable);
}

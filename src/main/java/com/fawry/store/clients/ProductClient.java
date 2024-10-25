package com.fawry.store.clients;


import com.fawry.store.dtos.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service", path = "/product-api")
public interface ProductClient {
    @GetMapping("/products/check-product/{productId}")
    boolean checkProductExists(@PathVariable Long productId);
    @GetMapping("/products/details")
    Page<ProductDto> getProductsByIds(@RequestParam List<Long> ids, Pageable pageable);
    @GetMapping("/products/search")
    List<ProductDto> searchProducts(@RequestParam(defaultValue = "") String name,
                                             @RequestParam(defaultValue = "") String category,
                                             @RequestParam(defaultValue = "") String code);
}

package com.fawry.store.clients;

import com.fawry.store.dtos.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductClientImpl implements ProductClient {
    @Override
    public boolean checkProductExists(Long productId) {
        return true;
    }

    @Override
    public Page<ProductDto> getProductsByIds(List<Long> productIds, Pageable pageable) {
        // return dummy products
        List<ProductDto> dummyProducts = productIds.stream()
                .map(id -> ProductDto.builder()
                        .id(id)
                        .name("Product " + id)
                        .sku("SKU" + id)
                        .code("CODE" + id)
                        .price(100.0)
                        .imageUrl("https://example.com/image" + id)
                        .description("Description of product " + id)
                        .categoryModel("Category " + id)
                        .build())
                .collect(Collectors.toList());

        return new PageImpl<>(dummyProducts, pageable, dummyProducts.size());
    }
}

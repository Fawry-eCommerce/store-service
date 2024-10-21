package com.fawry.store.clients.productclient;


//@FeignClient(name = "product-service")
public interface ProductClient {
    boolean checkProductExists(Long productId);
}

package com.fawry.store.clients.productclient;

import org.springframework.stereotype.Component;

@Component
public class ProductClientImpl implements ProductClient {
    @Override
    public boolean checkProductExists(Long productId) {
        return true;
    }
}

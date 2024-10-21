package com.fawry.store.enums;

import lombok.Getter;

@Getter
public enum Messages {
    PRODUCT_NOT_FOUND("Product not found"),
    STORE_NOT_FOUND("Store not found"),
    STORE_ALREADY_EXISTS("Store already exists"),
    INSUFFICIENT_STOCK("Insufficient stock"),
    PRODUCT_OUT_OF_STOCK("Product is out of stock");

    private final String message;

    Messages(String message) {
        this.message = message;
    }
}

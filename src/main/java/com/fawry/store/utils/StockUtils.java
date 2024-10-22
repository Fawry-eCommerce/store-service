package com.fawry.store.utils;

import com.fawry.store.entities.Stock;
import com.fawry.store.enums.Messages;
import com.fawry.store.exception.InsufficientStockException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class StockUtils {

    public static void validateStock(Stock stock, int quantity) {
        if (stock == null || stock.getQuantity() == 0) {
            throw new EntityNotFoundException(Messages.PRODUCT_OUT_OF_STOCK.getMessage());
        }
        if (stock.getQuantity() < quantity) {
            throw new InsufficientStockException(Messages.INSUFFICIENT_STOCK.getMessage());
        }
    }

    public static int calculateTotalStock(List<Stock> stocks) {
        return stocks.stream()
                .mapToInt(Stock::getQuantity)
                .sum();
    }

}

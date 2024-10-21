package com.fawry.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "stock", indexes = {
        @Index(name = "idx_product_id", columnList = "productId"),
        @Index(name = "idx_store_id", columnList = "store_id")
})
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private int quantity;
}

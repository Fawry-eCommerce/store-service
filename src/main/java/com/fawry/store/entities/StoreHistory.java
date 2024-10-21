package com.fawry.store.entities;

import com.fawry.store.enums.StoreActionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    @Column(nullable = false)
    private String consumerEmail;
    @Column(nullable = false)
    private Long productId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreActionType actionType;
    @Column(nullable = false)
    private Long quantityChanged;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}

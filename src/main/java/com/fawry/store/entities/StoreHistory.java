package com.fawry.store.entities;

import com.fawry.store.enums.StoreHistoryActionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Store store;
    private String consumerEmail;
    private Long productId;
    @Enumerated(EnumType.STRING)
    private StoreHistoryActionType actionType;
    private Long quantityChanged;
    private LocalDateTime timestamp;
}

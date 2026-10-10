
package com.practice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private BigDecimal amount;

    private String currency;

    private LocalDateTime transactionDate;

    private String category;

    @PrePersist
    public void setTransactionDate() {
    if (transactionDate == null) {
        transactionDate = LocalDateTime.now();
    }
}
}


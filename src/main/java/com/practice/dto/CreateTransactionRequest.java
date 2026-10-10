package com.practice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

import lombok.Data;

@Data
public class CreateTransactionRequest {

    @NotNull(message = "Title cannot be null")
    private String title;

    private String description;

    @DecimalMin(
        value = "0.0",
        inclusive = false,
        message = "Amount must be greater than zero"
    )
    private BigDecimal amount;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    private LocalDateTime transactionDate;

    @NotNull(message = "Category cannot be null")
    private String category;
}
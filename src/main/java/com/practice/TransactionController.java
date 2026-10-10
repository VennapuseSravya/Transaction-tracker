
package com.practice.controller;

import com.practice.dto.CreateTransactionRequest;
import com.practice.entity.Transaction;
import com.practice.service.TransactionService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.practice.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    // Constructor injection
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

   @PostMapping("/create")
public ResponseEntity<ApiResponse<Transaction>> createTransaction(
        @Valid @RequestBody CreateTransactionRequest request) {

    Transaction transaction = new Transaction();
    transaction.setTitle(request.getTitle());
    transaction.setDescription(request.getDescription());
    transaction.setAmount(request.getAmount());
    transaction.setCurrency(request.getCurrency());
    transaction.setTransactionDate(request.getTransactionDate());
    transaction.setCategory(request.getCategory());

    Transaction savedTransaction =
            transactionService.createTransaction(transaction);

    ApiResponse<Transaction> response = new ApiResponse<>(
            "Transaction created successfully",
            HttpStatus.CREATED.value(),
            savedTransaction
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
}
}
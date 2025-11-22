package com.pbs.finman_backend.controller;

import com.pbs.finman_backend.dto.ExpenseDTO;
import com.pbs.finman_backend.entity.Expense;
import com.pbs.finman_backend.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.getUserExpenses(userId));
    }

    @GetMapping("/subcategory/{subCategoryId}")
    public ResponseEntity<List<Expense>> getExpensesBySubCategory(@PathVariable Long subCategoryId) {
        return ResponseEntity.ok(expenseService.getExpensesBySubCategory(subCategoryId));
    }

    // Add create, update, delete endpoints as needed
}


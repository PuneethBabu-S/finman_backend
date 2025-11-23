package com.pbs.finman_backend.controller;

import com.pbs.finman_backend.entity.Expense;
import com.pbs.finman_backend.service.IExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final IExpenseService expenseService;

    public ExpenseController(IExpenseService expenseService) {
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


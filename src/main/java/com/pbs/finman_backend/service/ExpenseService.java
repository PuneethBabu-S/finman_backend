package com.pbs.finman_backend.service;

import com.pbs.finman_backend.entity.Expense;
import com.pbs.finman_backend.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getUserExpenses(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public List<Expense> getExpensesBySubCategory(Long subCategoryId) {
        return expenseRepository.findBySubCategoryId(subCategoryId);
    }

    // Add create, update, delete methods as needed
}


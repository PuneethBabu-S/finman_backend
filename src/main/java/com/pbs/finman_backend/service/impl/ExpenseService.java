package com.pbs.finman_backend.service.impl;

import com.pbs.finman_backend.entity.Expense;
import com.pbs.finman_backend.repository.ExpenseRepository;
import com.pbs.finman_backend.service.IExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService implements IExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getUserExpenses(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    @Override
    public List<Expense> getExpensesBySubCategory(Long subCategoryId) {
        return expenseRepository.findBySubCategoryId(subCategoryId);
    }

    // Add create, update, delete methods as needed
}


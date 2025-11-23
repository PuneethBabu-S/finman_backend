package com.pbs.finman_backend.service;

import com.pbs.finman_backend.entity.Expense;

import java.util.List;

public interface IExpenseService {
    public List<Expense> getUserExpenses(Long userId);
    public List<Expense> getExpensesBySubCategory(Long subCategoryId);
}

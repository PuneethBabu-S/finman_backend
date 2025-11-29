package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    public String createCategory(CategoryDTO categoryDTO) throws Exception;
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) throws Exception;
    public String deleteCategory(Long categoryId) throws Exception;
    public CategoryDTO getCategoryById(Long categoryId);
    public List<CategoryDTO> getCategories(Boolean forAllUsers) throws Exception;
}

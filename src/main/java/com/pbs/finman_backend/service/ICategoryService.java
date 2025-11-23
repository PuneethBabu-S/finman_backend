package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    public CategoryDTO createCategory(CategoryDTO categoryDTO);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO);
    public String deleteCategory(Long categoryId);
    public CategoryDTO getCategoryById(Long categoryId);
    public List<CategoryDTO> getCategories(Boolean forAllUsers) throws Exception;
}

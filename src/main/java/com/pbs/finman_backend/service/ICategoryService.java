package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    public List<CategoryDTO> getGlobalCategories();
    public List<CategoryDTO> getUserCategories(Long userId);
    public void createCategory(CategoryDTO categoryDTO);
}

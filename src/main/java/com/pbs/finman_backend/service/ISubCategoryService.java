package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.SubCategoryDTO;

import java.util.List;

public interface ISubCategoryService {
    public List<SubCategoryDTO> getGlobalSubCategories();
    public List<SubCategoryDTO> getUserSubCategories(Long userId);
    public List<SubCategoryDTO> getSubCategoriesByCategory(Long categoryId);
    public SubCategoryDTO createSubCategory(SubCategoryDTO dto, Long userId);
}

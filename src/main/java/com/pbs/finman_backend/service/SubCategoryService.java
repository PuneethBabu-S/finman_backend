package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.SubCategoryDTO;
import com.pbs.finman_backend.entity.SubCategory;
import com.pbs.finman_backend.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> getGlobalSubCategories() {
        return subCategoryRepository.findByIsGlobalTrue();
    }

    public List<SubCategory> getUserSubCategories(Long userId) {
        return subCategoryRepository.findByOwnerId(userId);
    }

    public List<SubCategory> getSubCategoriesByCategory(Long categoryId) {
        return subCategoryRepository.findByParentCategoryId(categoryId);
    }

    public SubCategory createSubCategory(SubCategoryDTO dto, Long userId) {
        SubCategory subCategory = new SubCategory();
        subCategory.setName(dto.getName());
        subCategory.setDescription(dto.getDescription());
        subCategory.setIsGlobal(dto.getIsGlobal() != null ? dto.getIsGlobal() : false);
        if (!subCategory.getIsGlobal()) {
            // Set owner if not global
            subCategory.setOwner(new com.pbs.finman_backend.entity.User());
            subCategory.getOwner().setId(userId);
        }
        // Set parent category
        subCategory.setParentCategory(new com.pbs.finman_backend.entity.Category());
        subCategory.getParentCategory().setId(dto.getParentCategoryId());
        return subCategoryRepository.save(subCategory);
    }
}

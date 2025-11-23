package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.SubCategoryDTO;
import com.pbs.finman_backend.entity.SubCategory;
import com.pbs.finman_backend.mapper.SubCategoryMapper;
import com.pbs.finman_backend.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategoryDTO> getGlobalSubCategories() {
        List<SubCategory> byIsGlobalTrue = subCategoryRepository.findByIsGlobalTrue();
        return byIsGlobalTrue.stream()
                .map(SubCategoryMapper::toDto)
                .toList();
    }

    public List<SubCategoryDTO> getUserSubCategories(Long userId) {
        List<SubCategory> byOwnerId = subCategoryRepository.findByOwnerId(userId);
        return byOwnerId.stream()
                .map(SubCategoryMapper::toDto)
                .toList();
    }

    public List<SubCategoryDTO> getSubCategoriesByCategory(Long categoryId) {
        return subCategoryRepository.findByParentCategoryId(categoryId).stream()
                .map(SubCategoryMapper::toDto)
                .toList();
    }

    public SubCategoryDTO createSubCategory(SubCategoryDTO dto, Long userId) {
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
        SubCategory save = subCategoryRepository.save(subCategory);
        return SubCategoryMapper.toDto(save);
    }
}

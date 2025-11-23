package com.pbs.finman_backend.service.impl;

import com.pbs.finman_backend.dto.CategoryDTO;
import com.pbs.finman_backend.entity.Category;
import com.pbs.finman_backend.mapper.CategoryMapper;
import com.pbs.finman_backend.repository.CategoryRepository;
import com.pbs.finman_backend.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getGlobalCategories() {

        List<Category> byIsGlobalTrue = categoryRepository.findByIsGlobalTrue();
        return byIsGlobalTrue.stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public List<CategoryDTO> getUserCategories(Long userId) {

        List<Category> byOwnerId = categoryRepository.findByOwnerId(userId);
        return byOwnerId.stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public void createCategory(CategoryDTO categoryDTO) {
    }

    // Add create, update, delete methods as needed
}


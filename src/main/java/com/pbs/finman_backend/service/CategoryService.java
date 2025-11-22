package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.CategoryDTO;
import com.pbs.finman_backend.entity.Category;
import com.pbs.finman_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getGlobalCategories() {
        return categoryRepository.findByIsGlobalTrue();
    }

    public List<Category> getUserCategories(Long userId) {
        return categoryRepository.findByOwnerId(userId);
    }

    // Add create, update, delete methods as needed
}


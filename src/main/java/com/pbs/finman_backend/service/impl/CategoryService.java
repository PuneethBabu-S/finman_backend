package com.pbs.finman_backend.service.impl;

import com.pbs.finman_backend.dto.CategoryDTO;
import com.pbs.finman_backend.entity.Category;
import com.pbs.finman_backend.entity.Role;
import com.pbs.finman_backend.entity.User;
import com.pbs.finman_backend.mapper.CategoryMapper;
import com.pbs.finman_backend.repository.CategoryRepository;
import com.pbs.finman_backend.repository.UserRepository;
import com.pbs.finman_backend.service.IAuthService;
import com.pbs.finman_backend.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final IAuthService authService;

    public CategoryService(CategoryRepository categoryRepository, IAuthService authService, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authService = authService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String createCategory(CategoryDTO categoryDTO) throws Exception {

        if(categoryRepository.existsByName(categoryDTO.getName())){
            return "Category with the same name already exists";
        }

        User curentUser = getCurrentUser();
        Category category = CategoryMapper.toEntity(categoryDTO, curentUser);

        if(categoryDTO.getIsGlobal() && !curentUser.getRole().equals(Role.ADMIN)){
            category.setIsGlobal(false);
        }
        categoryRepository.save(category);
        return "Category created successfully";
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {

        return null;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        return "";
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public List<CategoryDTO> getCategories(Boolean forAllUsers) throws Exception {
        try {
            User user = getCurrentUser();
            Set<CategoryDTO> categories = new HashSet<>();
            if (forAllUsers && user.getRole().equals(Role.ADMIN)) {
                categoryRepository.findAll().forEach(category -> categories.add(CategoryMapper.toDto(category)));
                return categories.stream().toList();
            }

            categoryRepository.findByIsGlobalTrue().forEach(category -> categories.add(CategoryMapper.toDto(category)));
            categoryRepository.findByOwnerId(user.getId()).forEach(category -> categories.add(CategoryMapper.toDto(category)));
            return categories.stream().toList();
        }
        catch (Exception e) {
            throw new Exception("Failed to retrieve categories: " + e.getMessage());
        }
    }

    private User getCurrentUser() throws Exception {
        String userName = authService.getUserName();
        return userRepository.findByEmail(userName).orElseThrow(() -> new Exception("User not found"));
    }

}


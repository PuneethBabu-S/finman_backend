package com.pbs.finman_backend.controller;

import com.pbs.finman_backend.dto.CategoryDTO;
import com.pbs.finman_backend.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/global")
    public ResponseEntity<List<CategoryDTO>> getGlobalCategories() {
        return ResponseEntity.ok(categoryService.getGlobalCategories());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CategoryDTO>> getUserCategories(@PathVariable Long userId) {
        return ResponseEntity.ok(categoryService.getUserCategories(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(categoryDTO);
    }
}


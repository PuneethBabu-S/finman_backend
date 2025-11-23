package com.pbs.finman_backend.controller;

import com.pbs.finman_backend.dto.CategoryDTO;
import com.pbs.finman_backend.service.ICategoryService;
import jakarta.validation.Valid;
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

    @PostMapping("/create")
    public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) throws Exception {
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @GetMapping("getCategories")
    public ResponseEntity<List<CategoryDTO>> getCategories(@Valid @RequestParam(name = "forAllUsers", required = false, defaultValue = "false") Boolean forAllUsers) throws Exception {
        return ResponseEntity.ok(categoryService.getCategories(forAllUsers));
    }
}


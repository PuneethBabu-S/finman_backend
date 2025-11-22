package com.pbs.finman_backend.controller;

import com.pbs.finman_backend.dto.SubCategoryDTO;
import com.pbs.finman_backend.entity.SubCategory;
import com.pbs.finman_backend.service.SubCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/global")
    public ResponseEntity<List<SubCategory>> getGlobalSubCategories() {
        return ResponseEntity.ok(subCategoryService.getGlobalSubCategories());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SubCategory>> getUserSubCategories(@PathVariable Long userId) {
        return ResponseEntity.ok(subCategoryService.getUserSubCategories(userId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SubCategory>> getSubCategoriesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(subCategoryService.getSubCategoriesByCategory(categoryId));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<SubCategory> createSubCategory(@PathVariable Long userId, @Valid @RequestBody SubCategoryDTO dto) {
        return ResponseEntity.ok(subCategoryService.createSubCategory(dto, userId));
    }

}


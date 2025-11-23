package com.pbs.finman_backend.controller;

import com.pbs.finman_backend.dto.SubCategoryDTO;
import com.pbs.finman_backend.service.ISubCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {
    private final ISubCategoryService subCategoryService;

    public SubCategoryController(ISubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/global")
    public ResponseEntity<List<SubCategoryDTO>> getGlobalSubCategories() {
        return ResponseEntity.ok(subCategoryService.getGlobalSubCategories());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SubCategoryDTO>> getUserSubCategories(@PathVariable Long userId) {
        return ResponseEntity.ok(subCategoryService.getUserSubCategories(userId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SubCategoryDTO>> getSubCategoriesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(subCategoryService.getSubCategoriesByCategory(categoryId));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<SubCategoryDTO> createSubCategory(@PathVariable Long userId, @Valid @RequestBody SubCategoryDTO dto) {
        return ResponseEntity.ok(subCategoryService.createSubCategory(dto, userId));
    }

}


package com.pbs.finman_backend.repository;

import com.pbs.finman_backend.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByIsGlobalTrue();
    List<SubCategory> findByOwnerId(Long ownerId);
    List<SubCategory> findByParentCategoryId(Long categoryId);
}


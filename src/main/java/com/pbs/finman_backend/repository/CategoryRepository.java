package com.pbs.finman_backend.repository;

import com.pbs.finman_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByIsGlobalTrue();
    List<Category> findByOwnerId(Long ownerId);
    Boolean existsByName(String name);
}


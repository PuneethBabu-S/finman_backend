package com.pbs.finman_backend.mapper;

import com.pbs.finman_backend.dto.CategoryDTO;
import com.pbs.finman_backend.entity.Category;
import com.pbs.finman_backend.entity.User;

public class CategoryMapper {
    public static CategoryDTO toDto(Category entity) {
        if (entity == null) return null;

        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIsGlobal(entity.getIsGlobal());
        User owner = entity.getOwner();
        if (owner != null) {
            dto.setOwnerId(owner.getId());
        } else {
            dto.setOwnerId(null);
        }
        return dto;
    }
}

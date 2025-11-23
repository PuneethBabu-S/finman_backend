package com.pbs.finman_backend.mapper;

import com.pbs.finman_backend.dto.SubCategoryDTO;
import com.pbs.finman_backend.entity.Category;
import com.pbs.finman_backend.entity.SubCategory;
import com.pbs.finman_backend.entity.User;

public class SubCategoryMapper {
    public static SubCategoryDTO toDto(SubCategory entity) {
        if (entity == null) return null;

        SubCategoryDTO dto = new SubCategoryDTO();
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
        Category parent = entity.getParentCategory();
        if (parent != null) {
            dto.setParentCategoryId(parent.getId());
        } else {
            dto.setParentCategoryId(null);
        }

        return dto;
    }

}

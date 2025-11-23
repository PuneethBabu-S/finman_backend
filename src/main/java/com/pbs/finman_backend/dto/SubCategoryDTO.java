package com.pbs.finman_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryDTO {
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private Boolean isGlobal;
    private Long ownerId;
    private Long parentCategoryId;
}




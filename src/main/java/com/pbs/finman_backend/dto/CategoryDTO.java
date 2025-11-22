package com.pbs.finman_backend.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryDTO {
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private Boolean isGlobal;
    private Long ownerId;
}




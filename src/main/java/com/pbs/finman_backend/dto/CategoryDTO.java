package com.pbs.finman_backend.dto;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Boolean isGlobal;
    private Long ownerId;
}




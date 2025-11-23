package com.pbs.finman_backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class ExpenseDTO {
    private Long id;
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;
    @NotNull
    private Instant date;
    private String description;
    @NotNull
    private Long userId;
    @NotNull
    private Long subCategoryId;
}




package com.example.handmade.model.dto;

import com.example.handmade.model.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDto(
        String productName,
        BigDecimal price,
        String description,
        String manufacturer,
        Integer quantity,
        @NotNull
        ProductCategory category,
        String status
) {
}

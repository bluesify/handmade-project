package com.example.handmade.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductDto(
    Long productId,
    String productName,
    BigDecimal price,
    String description,
    String manufacturer,
    Integer quantity,
    String category,
    String status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    SellerDto seller
) {
}

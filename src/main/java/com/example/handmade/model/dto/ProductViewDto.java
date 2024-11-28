package com.example.handmade.model.dto;

public record ProductViewDto(
        Long productId,
        String productName,
        int quantity,
        String status
) {
}

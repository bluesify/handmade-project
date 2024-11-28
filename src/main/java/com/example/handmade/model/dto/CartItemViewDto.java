package com.example.handmade.model.dto;

public record CartItemViewDto(
        Long cartItemId,
        Long quantity,
        ProductView product
) {
}

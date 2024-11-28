package com.example.handmade.model.dto;

public record CartItemDto(
        Long cartItemId,
        Long quantity,
        ProductDto product
) {
}

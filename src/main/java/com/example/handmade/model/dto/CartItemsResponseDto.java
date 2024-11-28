package com.example.handmade.model.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CartItemsResponseDto {
    private int total;
    private List<CartItemViewDto> cartItems;

    public CartItemsResponseDto(List<CartItemViewDto> cartItems) {
        this(cartItems.size(), cartItems);
    }
}
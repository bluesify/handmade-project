package com.example.handmade.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddCartItemRequest extends CartItemRequest {

    private Long productId;
}
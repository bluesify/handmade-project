package com.example.handmade.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddCartItemRequestDtoDto extends CartItemRequestDto {

    private Long productId;
}
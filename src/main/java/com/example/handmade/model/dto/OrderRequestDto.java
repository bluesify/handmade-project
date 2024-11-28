package com.example.handmade.model.dto;

import com.example.handmade.model.constant.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDto(
        @NotNull
        OrderStatus status
) {
}

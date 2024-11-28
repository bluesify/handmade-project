package com.example.handmade.model.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}

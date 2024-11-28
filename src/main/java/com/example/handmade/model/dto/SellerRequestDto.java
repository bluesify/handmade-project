package com.example.handmade.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SellerRequestDto(
        String firstName,
        String lastName,
        String phoneNumber,

        @Email
        String email,
        @NotBlank
        String username
) {
}

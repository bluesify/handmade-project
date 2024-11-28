package com.example.handmade.model.dto;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequestDto(
    @NotBlank
    String currentPassword,
    @NotBlank
    String newPassword,
    @NotBlank
    String confirmNewPassword
) {
}

package com.example.handmade.model.dto;

import java.time.LocalDateTime;

public record SellerDto(
        Long sellerId,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String username,
        String password,
        RoleDto role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}

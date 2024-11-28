package com.example.handmade.model.dto;

public record CustomerViewDto(
        Long customerId,
        String firstName,
        String phoneNumber,
        String email
) {
}

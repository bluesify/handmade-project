package com.example.handmade.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CustomerDto(
    Long customerId,
    String firstName,
    String lastName,
    String phoneNumber,
    String email,
    String username,
    String password,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    List<AddressDto> addresses,
    List<CreditCardDto> creditCards,
    RoleDto role
) {
}

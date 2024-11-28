package com.example.handmade.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreditCardRequestDto(
        @NotBlank
        String cardNumber,
        @NotBlank
        String cardHolderName,
        @NotNull
        LocalDate expirationDate,
        @NotBlank
        String cvc
) {
}

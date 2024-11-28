package com.example.handmade.model.dto;

public record AccessTokenDto(String accessToken, String tokenType, Long expiresIn) {
}

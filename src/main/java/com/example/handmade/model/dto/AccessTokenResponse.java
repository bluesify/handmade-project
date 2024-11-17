package com.example.handmade.model.dto;

public record AccessTokenResponse(String accessToken, String tokenType, Long expiresIn) {
}

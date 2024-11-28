package com.example.handmade.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequestDto {
        String firstName;
        String lastName;
        String phoneNumber;

        @Email
        String email;

        @NotBlank
        String username;
}

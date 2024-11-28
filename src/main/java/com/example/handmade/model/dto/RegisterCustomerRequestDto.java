package com.example.handmade.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterCustomerRequestDto extends CustomerRequestDto {

    @NotBlank
    String password;

    @Valid
    private List<RegisterAddressRequestDto> addresses;

    @Valid
    private List<CreditCardRequestDto> creditCards;

}
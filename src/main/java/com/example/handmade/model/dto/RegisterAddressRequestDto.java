package com.example.handmade.model.dto;

import com.example.handmade.model.constant.AddressType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterAddressRequestDto extends AddressRequestDto {
    @NotNull
    private AddressType type;
}

package com.example.handmade.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AddressRequestDto {
    private String address1;
    private String address2;
    private String city;
    private String province;
    private String zipCode;
}

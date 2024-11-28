package com.example.handmade.model.dto;

public record AddressDto(
     Long addressId,
     String type,
     String address1,
     String address2,
     String city,
     String province,
     String zipCode) {
}

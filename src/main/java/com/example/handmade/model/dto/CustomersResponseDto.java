package com.example.handmade.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CustomersResponseDto {
    private int total;
    private List<CustomerViewDto> customers;

    public CustomersResponseDto(List<CustomerViewDto> customers) {
        this(customers.size(), customers);
    }
}

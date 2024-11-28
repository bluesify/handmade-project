package com.example.handmade.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record OrderDto(
        Long orderId,
        String status,
        LocalDate orderDate,
        BigDecimal total,
        CustomerViewDto customer,
        CreditCardDto creditCard,
        AddressDto address,
        List<CartItemDto> cartItems
) {
}

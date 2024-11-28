package com.example.handmade.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OrderViewDto(
        Long orderId,
        LocalDate orderDate,
        String status,
        BigDecimal total
) {
}

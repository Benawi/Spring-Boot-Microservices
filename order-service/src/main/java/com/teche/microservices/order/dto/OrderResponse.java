package com.teche.microservices.order.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;

public record OrderResponse(long id, String orderNumber, String skuCode, BigDecimal
        price, Integer quantity) {
}

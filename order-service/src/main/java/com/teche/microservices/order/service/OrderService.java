package com.teche.microservices.order.service;

import com.teche.microservices.order.dto.OrderRequest;
import com.teche.microservices.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import com.teche.microservices.order.model.Order;
import org.springframework.stereotype.Service;
import com.teche.microservices.order.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest)
    {
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(order.getId(),order.getOrderNumber(),order.getSkuCode(),order.getPrice(),order.getQuantity()))
                .toList();
    }
}

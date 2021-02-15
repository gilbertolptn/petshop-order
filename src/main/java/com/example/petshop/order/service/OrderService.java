package com.example.petshop.order.service;

import com.example.petshop.order.dto.OrderDetails;

public interface OrderService {
    void create(OrderDetails orderDetails);
}

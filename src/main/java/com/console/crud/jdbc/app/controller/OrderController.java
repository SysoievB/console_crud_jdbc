package com.console.crud.jdbc.app.controller;

import com.console.crud.jdbc.app.model.Order;
import com.console.crud.jdbc.app.repository.OrderRepository;
import com.console.crud.jdbc.app.repository.impl.OrderRepositoryImpl;

import java.util.List;

public class OrderController {
    private OrderRepository orderRepository = new OrderRepositoryImpl();

    public List<Order> printAll() {
        return orderRepository.getAll();
    }

    public void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    public void deleteOrder(Long index) {
        orderRepository.deleteById(index);
    }

    public void updateOrder(Long id, Order updateOrder) {
        orderRepository.update(id, updateOrder);

    }

    public Order getValueByIndex(Long index) {
        return orderRepository.getById(index);
    }
}


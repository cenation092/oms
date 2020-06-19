package com.assignment.oms.controller;

import com.assignment.oms.model.Order;
import com.assignment.oms.model.Product;
import com.assignment.oms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/order")
    public Order Buy(@RequestBody Order newOrder ){
        return orderRepository.save((newOrder));
    }
}

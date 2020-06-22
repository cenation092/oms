package com.assignment.oms.services.implementation;

import com.assignment.oms.dto.ApiResponseVO;
import com.assignment.oms.model.Order;
import com.assignment.oms.repository.OrderRepository;
import com.assignment.oms.services.OrderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class OrderServiceImpl implements OrderSevice {
    @Autowired
    private OrderRepository orderRepository;

    public Order Buy(Order newOrder ){
        return orderRepository.save((newOrder));
    }
}

package com.assignment.oms.services;

import com.assignment.oms.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface OrderSevice {
    public Order Buy( Order newOrder );
}

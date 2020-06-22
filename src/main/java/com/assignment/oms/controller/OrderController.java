package com.assignment.oms.controller;

import com.assignment.oms.dto.ProductCategoryResponseVO;
import com.assignment.oms.model.Order;
import com.assignment.oms.repository.OrderRepository;
import com.assignment.oms.services.OrderSevice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class OrderController {

    @Autowired
    private OrderSevice orderSevice;


    @ApiOperation(value = "Place your order",
            notes = "Place your order", response = Order.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/order", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('USER')")
    public Order Buy(@RequestBody Order newOrder ){
        return orderSevice.Buy((newOrder));
    }
}

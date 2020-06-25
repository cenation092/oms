package com.assignment.oms.repository;

import com.assignment.oms.model.Order;
import com.assignment.oms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

package com.assignment.oms.repository;

import com.assignment.oms.model.Product;
import com.assignment.oms.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByproductCategory(ProductCategory productCategory );
}

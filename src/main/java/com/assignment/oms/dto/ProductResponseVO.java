package com.assignment.oms.dto;

import com.assignment.oms.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductResponseVO {
    List<Product> productList;
}

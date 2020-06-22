package com.assignment.oms.services;

import com.assignment.oms.dto.ProductResponseVO;
import com.assignment.oms.dto.UpdateProductRequestVO;
import com.assignment.oms.exceptions.NotFoundException;
import com.assignment.oms.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public interface AdminUserService {

    public ProductResponseVO all();

    public Long anyQuery(Long productId, String query );

    public Product addProduct(Product newProduct);

    public Product updateProduct(Long productId, UpdateProductRequestVO updateProductRequestVO);

    public void deleteProduct(Long productId);
}

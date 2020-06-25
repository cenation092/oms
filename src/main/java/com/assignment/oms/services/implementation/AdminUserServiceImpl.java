package com.assignment.oms.services.implementation;

import com.assignment.oms.dto.GetProductRequestVO;
import com.assignment.oms.dto.ProductCategoryResponseVO;
import com.assignment.oms.dto.ProductResponseVO;
import com.assignment.oms.dto.UpdateProductRequestVO;
import com.assignment.oms.exceptions.NotFoundException;
import com.assignment.oms.model.Product;
import com.assignment.oms.model.ProductCategory;
import com.assignment.oms.repository.ProductRepository;
import com.assignment.oms.services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseVO all(){
        List<Product> productRepositoryAll = productRepository.findAll();
        return ProductResponseVO.builder().productList(productRepositoryAll).build();
    }

    public String anyQuery(GetProductRequestVO info) {
        return productRepository.findById(info.getId())
            .map(product -> {
                if (info.getQuery().equals("price")) {
                    Long val = product.getPrice();
                    String queryResponse = "Price = ";
                    queryResponse = queryResponse.concat(val.toString());
                    return queryResponse;
                } else {
                    Long val = product.getStockUnits();
                    String queryResponse = "Stock Availability = ";
                    queryResponse = queryResponse.concat(val.toString());
                    return queryResponse;
                }
            })
            .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    public Product addProduct(Product newProduct){
        return productRepository.save(newProduct);
    }

    public Product updateProduct(Long productId, UpdateProductRequestVO updateProductRequestVO) {
        return productRepository.findById(productId)
            .map( product -> {
                if( updateProductRequestVO.getPrice() != null ){
                    product.setPrice(updateProductRequestVO.getPrice());
                }
                if( updateProductRequestVO.getStockUnit() != null ){
                    product.setStockUnits(product.getStockUnits()+updateProductRequestVO.getStockUnit());
                }
                return productRepository.save(product);
            })
            .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }
}

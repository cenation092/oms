package com.assignment.oms.controller;

import com.assignment.oms.model.ProductCategory;
import com.assignment.oms.repository.ProductCategoryRepository;
import com.assignment.oms.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/product-category")
    public List<ProductCategory> all(){
        return productCategoryRepository.findAll();
    }

    @PostMapping("/product-category")
    public ProductCategory newCategory(@RequestBody ProductCategory newProductCategory){
        return productCategoryRepository.save(newProductCategory);
    }

    @PutMapping("/product-category/{productCategoryId}")
    public ProductCategory updateCategory(@RequestBody ProductCategory newCategory, @PathVariable Long productCategoryId ){
        return productCategoryRepository.findById(productCategoryId)
                .map( product -> {
                    product.setCategoryName(newCategory.getCategoryName());
                    return productCategoryRepository.save(product);
                })
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @DeleteMapping("/product-category/{productCategoryId}")
    public void deleteCategory(@PathVariable Long productCategoryId ){
        productCategoryRepository.deleteById(productCategoryId);
    }

}

package com.assignment.oms.controller;

import com.assignment.oms.exceptions.NotFoundException;
import com.assignment.oms.model.Product;
import com.assignment.oms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> all(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{query}/{productId}")
    public Long anyQuery(@PathVariable Long productId, @PathVariable String query ) {
        return productRepository.findById(productId)
                .map(product -> {
                    if (query.equals("price")) {
                        return product.getPrice();
                    } else {
                        return product.getStockUnits();
                    }
                })
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product newProduct){
        return productRepository.save(newProduct);
    }

//    @PutMapping("/product/{query}/{productId}")
//    public Product updateProduct(Long value, @PathVariable Long productId, @PathVariable String query ){
//        return productRepository.findById(productId)
//        .map( product -> {
//            if(query.equals("price")){
//                product.setPrice(value);
//            }
//            else{
//                product.setStockUnits(product.getStockUnits()+value);
//            }
//            return productRepository.save(product);
//        })
//        .orElseThrow(() -> new NotFoundException("Category not found"));
//    }

    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productRepository.deleteById(productId);
    }

}

package com.assignment.oms.controller;

import com.assignment.oms.dto.ProductCategoryResponseVO;
import com.assignment.oms.dto.ProductResponseVO;
import com.assignment.oms.dto.UpdateProductRequestVO;
import com.assignment.oms.exceptions.NotFoundException;
import com.assignment.oms.model.Product;
import com.assignment.oms.model.ProductCategory;
import com.assignment.oms.repository.ProductRepository;
import com.assignment.oms.services.AdminUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProductController {

    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation(value = "Get all products",
            notes = "Get all products", response = ProductResponseVO.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ProductResponseVO all(){
        return adminUserService.all();
    }

    @ApiOperation(value = "Add new product",
            notes = "Add new product", response = Product.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/product", method = RequestMethod.POST, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public Product addProduct(@RequestBody Product newProduct){
        return adminUserService.addProduct(newProduct);
    }

    @ApiOperation(value = "Update existing product",
            notes = "Update existing product", response = Product.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody UpdateProductRequestVO
            updateProductRequestVO) {
        return adminUserService.updateProduct(productId, updateProductRequestVO);
    }

    @ApiOperation(value = "Delete existing product",
            notes = "Delete existing product", response = void.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable Long productId){
        adminUserService.deleteProduct(productId);
    }

}

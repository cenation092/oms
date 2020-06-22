package com.assignment.oms.controller;

import com.assignment.oms.dto.ProductCategoryResponseVO;
import com.assignment.oms.model.ProductCategory;
import com.assignment.oms.services.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProductCategoryController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "Get all product categories",
            notes = "Get all product categories", response = ProductCategoryResponseVO.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/productCategory", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public ProductCategoryResponseVO all(){
        return adminService.all();
    }

    @ApiOperation(value = "Add new product category",
            notes = "Add new product category", response = ProductCategory.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/productCategory", method = RequestMethod.POST, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public ProductCategory newCategory(@RequestBody ProductCategory newProductCategory){
        return adminService.newCategory(newProductCategory);
    }

    @ApiOperation(value = "Update existing product category",
            notes = "Update existing product category", response = ProductCategory.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/productCategory/{productCategoryId}", method = RequestMethod.PUT, produces =
            {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public ProductCategory updateCategory(@RequestBody ProductCategory newCategory, @PathVariable("productCategoryId")
            Long productCategoryId ){
        return adminService.updateCategory(productCategoryId, newCategory);
    }

    @ApiOperation(value = "Delete existing product category",
            notes = "Delete existing product category", response = void.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/productCategory/{productCategoryId}", method = RequestMethod.DELETE, produces =
            {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategory(@PathVariable("productCategoryId") Long productCategoryId ){
        adminService.deleteCategory(productCategoryId);
    }

}

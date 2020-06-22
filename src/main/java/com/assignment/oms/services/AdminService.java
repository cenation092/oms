package com.assignment.oms.services;

import com.assignment.oms.dto.ProductCategoryResponseVO;
import com.assignment.oms.model.ProductCategory;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public ProductCategoryResponseVO all();

    public ProductCategory newCategory(ProductCategory newProductCategory);

    public ProductCategory updateCategory(Long productCategoryId, ProductCategory newCategory);

    public void deleteCategory(Long productCategoryId);
}

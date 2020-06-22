package com.assignment.oms.services.implementation;

import com.assignment.oms.dto.ProductCategoryResponseVO;
import com.assignment.oms.exceptions.NotFoundException;
import com.assignment.oms.model.ProductCategory;
import com.assignment.oms.repository.ProductCategoryRepository;
import com.assignment.oms.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategoryResponseVO all(){
        List<ProductCategory> productCategoryRepositoryAll = productCategoryRepository.findAll();
        return ProductCategoryResponseVO.builder().productCategories(productCategoryRepositoryAll).build();
    }

    @Override
    public ProductCategory newCategory(ProductCategory newProductCategory){
        return productCategoryRepository.save(newProductCategory);
    }

    @Override
    public ProductCategory updateCategory(Long productCategoryId, ProductCategory newCategory){
        return productCategoryRepository.findById(productCategoryId)
            .map( product -> {
                product.setCategoryName(newCategory.getCategoryName());
                return productCategoryRepository.save(product);
            })
            .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public void deleteCategory(Long productCategoryId){
        productCategoryRepository.deleteById(productCategoryId);
    }
}

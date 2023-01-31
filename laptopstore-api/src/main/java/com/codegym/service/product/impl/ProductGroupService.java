package com.codegym.service.product.impl;

import com.codegym.dto.ProductDto;
import com.codegym.dto.ProductGroupDetailDto;
import com.codegym.dto.ProductGroupDto;
import com.codegym.model.product.ProductGroup;
import com.codegym.repository.product.IProductGroupRepository;
import com.codegym.service.product.IProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductGroupService implements IProductGroupService {
    @Autowired
    private IProductGroupRepository productGroupRepository;

    @Override
    public List<ProductGroup> findAll() {
        return productGroupRepository.findAll();
    }

    @Override
    public List<ProductGroupDto> getAll() {
        return productGroupRepository.getAll();
    }

    @Override
    public ProductGroupDetailDto getAllDetail(Integer id) {
        return productGroupRepository.getAllDetail(id);
    }

    @Override
    public Optional<ProductDto> getProductById(Integer id) {
        return productGroupRepository.getProductById(id);
    }
}

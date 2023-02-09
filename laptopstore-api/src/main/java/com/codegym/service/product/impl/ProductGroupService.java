package com.codegym.service.product.impl;

import com.codegym.dto.*;
import com.codegym.model.product.ProductGroup;
import com.codegym.repository.product.IProductGroupRepository;
import com.codegym.service.product.IProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<ProductGroupDto> search(SearchDto searchDto) {
        return productGroupRepository.search(searchDto);
    }

    @Override
    public Page<ProductGroupDto> search(SearchDto searchDto, Pageable pageable) {
        return productGroupRepository.searchAndPage(searchDto, pageable);
    }

    @Override
    public Page<Demopage> searchdemo(SearchDto searchDto, Pageable pageable) {
        return productGroupRepository.demopage(pageable);
    }

    @Override
    public List<ProductDetailListDto> getAllProductDetailByProductgroupId(String id) {
        return productGroupRepository.getAllProductDetailByProductgroupId(id);
    }
}

package com.codegym.service.product.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.product.IProductRepository;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product findByid(Integer idProduct) {
        return productRepository.findById(idProduct).get();
    }
}

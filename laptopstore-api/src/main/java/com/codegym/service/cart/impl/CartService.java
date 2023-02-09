package com.codegym.service.cart.impl;

import com.codegym.dto.ProductCartDto;
import com.codegym.repository.product.IProductGroupRepository;
import com.codegym.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private IProductGroupRepository productGroupRepository;

    @Override
    public List<ProductCartDto> getProductByUserId(String id) {
        return productGroupRepository.getProductByUserId(id);
    }

    @Override
    public List<ProductCartDto> getProductByUserIdPay(Integer id) {
        return productGroupRepository.getProductByUserIdPay(id);
    }
}

package com.codegym.service.cart;

import com.codegym.dto.ProductCartDto;

import java.util.List;

public interface ICartService {
    List<ProductCartDto> getProductByUserId(String id);

    List<ProductCartDto> getProductByUserIdPay(Integer id);
}

package com.codegym.service.product;

import com.codegym.model.product.Product;

public interface IProductService {
    Product findByid(Integer idProduct);
}

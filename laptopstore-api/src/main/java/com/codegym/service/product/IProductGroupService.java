package com.codegym.service.product;

import com.codegym.dto.ProductDto;
import com.codegym.dto.ProductGroupDetailDto;
import com.codegym.dto.ProductGroupDto;
import com.codegym.model.product.ProductGroup;

import java.util.List;
import java.util.Optional;

public interface IProductGroupService {
    List<ProductGroup> findAll();

    List<ProductGroupDto> getAll();

    ProductGroupDetailDto getAllDetail(Integer id);

    Optional<ProductDto> getProductById(Integer id);
}

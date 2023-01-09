package com.codegym.service.product;

import com.codegym.dto.ProductGroupDetailDto;
import com.codegym.dto.ProductGroupDto;
import com.codegym.model.product.ProductGroup;

import java.util.List;

public interface IProductGroupService {
    List<ProductGroup> findAll();

    List<ProductGroupDto> getAll();

    ProductGroupDetailDto getAllDetail(Integer id);
}

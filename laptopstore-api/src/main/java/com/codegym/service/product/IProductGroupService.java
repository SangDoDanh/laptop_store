package com.codegym.service.product;

import com.codegym.dto.*;
import com.codegym.model.product.ProductGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductGroupService {
    List<ProductGroup> findAll();

    List<ProductGroupDto> getAll();

    ProductGroupDetailDto getAllDetail(Integer id);

    Optional<ProductDto> getProductById(Integer id);

    List<ProductGroupDto> search(SearchDto searchDto);

    Page<ProductGroupDto> search(SearchDto searchDto, Pageable pageable);

    Page<Demopage> searchdemo(SearchDto searchDto, Pageable pageable);

    List<ProductDetailListDto> getAllProductDetailByProductgroupId(String id);
}

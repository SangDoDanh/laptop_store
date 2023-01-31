package com.codegym.controller.product;

import com.codegym.dto.ProductDto;
import com.codegym.dto.ProductGroupDto;
import com.codegym.dto.ProductGroupDetailDto;
import com.codegym.service.product.IProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/product-groups")
public class ProductGroupRestController {
    @Autowired
    private IProductGroupService productGroupService;

    /**
     * Create: SangDD
     * Date: 08/01/2023
     * function: get all product group
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ProductGroupDto>> getAll() {
        List<ProductGroupDto> productGroupDtos = productGroupService.getAll();
        return new ResponseEntity<>(productGroupDtos, HttpStatus.OK);
    }

    /**
     * Create: SangDD
     * Date: 09/01/2023
     * function: get product group detail by id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<ProductGroupDetailDto> getAllDetail(@PathVariable Integer id) {
        ProductGroupDetailDto productGroupDetailDtos = productGroupService.getAllDetail(id);
        return new ResponseEntity<>(productGroupDetailDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {
        Optional<ProductDto> productDto = productGroupService.getProductById(id);
        return new ResponseEntity<>(productDto.get(), HttpStatus.OK);
    }
}

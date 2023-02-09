package com.codegym.controller.product;

import com.codegym.dto.*;
import com.codegym.service.cart.ICartService;
import com.codegym.service.product.IProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private ICartService cartService;

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

    @PostMapping("/search")
    public ResponseEntity<List<ProductGroupDto>> search(@RequestBody SearchDto searchDto) {
        List<ProductGroupDto> productGroupDtos = productGroupService.search(searchDto);
        return new ResponseEntity<>(productGroupDtos, HttpStatus.OK);
    }

    @PostMapping("/search-page")
    public ResponseEntity<?> getAllAndSearch(@RequestBody SearchDto searchDto, @PageableDefault(value = 3)Pageable pageable) {
        Page<ProductGroupDto> productGroupDtos = productGroupService.search(searchDto, pageable);
        return new ResponseEntity<>(productGroupDtos, HttpStatus.OK);
    }

    @PostMapping("/demo-page")
    public ResponseEntity<?> getAllAndSearchDemo(@RequestBody SearchDto searchDto, @PageableDefault(value = 3)Pageable pageable) {
        Page<Demopage> productGroupDtos = productGroupService.searchdemo(searchDto, pageable);
        return new ResponseEntity<>(productGroupDtos, HttpStatus.OK);
    }

    @GetMapping("/products-list-detail/{id}")
    public ResponseEntity<List<ProductDetailListDto>>getAllProductDetailByProductgroupId(@PathVariable String id) {
        List<ProductDetailListDto> productListDetail = productGroupService.getAllProductDetailByProductgroupId(id);
        return new ResponseEntity<>(productListDetail, HttpStatus.OK);
    }

    @GetMapping("/products-list-pay/{id}")
    public ResponseEntity<List<ProductCartDto>> getAllProductListpay(@PathVariable Integer id) {
        List<ProductCartDto> productCartDtos = cartService.getProductByUserIdPay(id);
        return new ResponseEntity<>(productCartDtos, HttpStatus.OK);
    }
}

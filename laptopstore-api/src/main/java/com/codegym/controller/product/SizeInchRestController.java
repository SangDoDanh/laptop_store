package com.codegym.controller.product;

import com.codegym.dto.SizeInchDto;
import com.codegym.service.product.ISizeInchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/size-inch")
public class SizeInchRestController {
    @Autowired
    private ISizeInchService sizeInchService;

    @GetMapping("")
    public ResponseEntity<List<SizeInchDto>> getAll() {
        List<SizeInchDto> sizeInchDtos = sizeInchService.getAll();
        return new ResponseEntity<>(sizeInchDtos, HttpStatus.OK);
    }
}

package com.codegym.service.product.impl;

import com.codegym.dto.SizeInchDto;
import com.codegym.repository.product.ISizeInchRepository;
import com.codegym.service.product.ISizeInchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeInchService implements ISizeInchService {
    @Autowired
    private ISizeInchRepository sizeInchRepository;

    @Override
    public List<SizeInchDto> getAll() {
        return sizeInchRepository.getAll();
    }
}

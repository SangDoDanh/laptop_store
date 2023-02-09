package com.codegym.service.product.impl;

import com.codegym.dto.ProducerForLapDto;
import com.codegym.repository.product.IProducerRepository;
import com.codegym.service.product.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService implements IProducerService {
    @Autowired
    private IProducerRepository producerRepository;

    @Override
    public List<ProducerForLapDto> getAllForLap() {
        return producerRepository.getAllForLap();
    }
}

package com.codegym.service.product;

import com.codegym.dto.ProducerForLapDto;

import java.util.List;

public interface IProducerService {
    List<ProducerForLapDto> getAllForLap();
}

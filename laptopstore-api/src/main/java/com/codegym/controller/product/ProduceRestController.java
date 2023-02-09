package com.codegym.controller.product;

import com.codegym.dto.ProducerForLapDto;
import com.codegym.service.product.IProducerService;
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
@RequestMapping("/api/v1/producer")
public class ProduceRestController {

    @Autowired
    private IProducerService producerService;

    @GetMapping("/for-lap")
    public ResponseEntity<List<ProducerForLapDto>> getAllForLap() {
        List<ProducerForLapDto> producerForLapDtos = producerService.getAllForLap();
        return  new ResponseEntity<>(producerForLapDtos, HttpStatus.OK);
    }
}

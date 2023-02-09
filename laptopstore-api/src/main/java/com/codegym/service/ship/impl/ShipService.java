package com.codegym.service.ship.impl;

import com.codegym.dto.ShipDto;
import com.codegym.repository.ship.IShipRepository;
import com.codegym.service.ship.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService implements IShipService {
    @Autowired
    private IShipRepository shipRepository;

    @Override
    public List<ShipDto> getAll() {
        return shipRepository.getAll();
    }
}

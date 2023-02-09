package com.codegym.service.cart.impl;

import com.codegym.model.orders.Orders;
import com.codegym.repository.cart.IOrdersRepository;
import com.codegym.service.cart.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService implements IOrderService {
    @Autowired
    private IOrdersRepository ordersRepository;

    @Override
    public void save(Orders orders) {
        ordersRepository.save(orders);
    }
}

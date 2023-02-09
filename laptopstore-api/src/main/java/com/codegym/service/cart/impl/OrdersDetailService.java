package com.codegym.service.cart.impl;

import com.codegym.model.orders.OrdersDetail;
import com.codegym.repository.cart.IOrdersDetailRepository;
import com.codegym.service.cart.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersDetailService implements IOrdersDetailService {
    @Autowired
    private IOrdersDetailRepository ordersDetailRepository;

    @Override
    public void save(OrdersDetail ordersDetail) {
        ordersDetailRepository.save(ordersDetail);
    }

    @Override
    public OrdersDetail findById(Integer ordersId) {
        return ordersDetailRepository.findById(ordersId).get();
    }
}

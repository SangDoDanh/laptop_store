package com.codegym.service.cart;

import com.codegym.model.orders.OrdersDetail;

public interface IOrdersDetailService {
    void save(OrdersDetail ordersDetail);

    OrdersDetail findById(Integer ordersId);
}

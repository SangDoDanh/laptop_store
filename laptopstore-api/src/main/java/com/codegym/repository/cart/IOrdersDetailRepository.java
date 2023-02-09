package com.codegym.repository.cart;

import com.codegym.model.orders.OrdersDetail;
import com.codegym.service.cart.impl.OrdersDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersDetailRepository extends JpaRepository<OrdersDetail, Integer> {

}

package com.codegym.service.customer;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;

import java.util.Optional;

public interface ICustomerService {

    Optional<Customer> findByidAccount(Integer idAccount);

    CustomerDto getCustomerByAccountId(Integer accountId);
}

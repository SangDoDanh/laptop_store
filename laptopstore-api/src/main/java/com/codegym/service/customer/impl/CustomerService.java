package com.codegym.service.customer.impl;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Optional<Customer> findByidAccount(Integer idAccount) {
        return customerRepository.findByIdAccount(idAccount);
    }

    @Override
    public CustomerDto getCustomerByAccountId(Integer accountId) {
        return customerRepository.getCustomerByAccountId(accountId);
    }
}

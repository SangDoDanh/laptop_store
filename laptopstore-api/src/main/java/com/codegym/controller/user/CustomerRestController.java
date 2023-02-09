package com.codegym.controller.user;

import com.codegym.dto.CustomerDto;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/account-id/{accountId}")
    public ResponseEntity<CustomerDto> getCustomerByAccountId(@PathVariable Integer accountId) {
        CustomerDto customerDto = customerService.getCustomerByAccountId(accountId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
}

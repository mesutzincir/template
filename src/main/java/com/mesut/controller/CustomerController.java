package com.mesut.controller;

import com.mesut.dto.ResponseObject;
import com.mesut.model.Customer;
import com.mesut.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/customer/{id}")
    public ResponseObject<Customer> getCustomerById(@PathVariable(name = "id") Long pId) {
        System.out.println("customer start.");
        return new ResponseObject<Customer>(customerService.getCustomer(pId));
    }

    @GetMapping("customer/find-all-page/{page}/{size}")
    public Page<Customer> findPaginated(@PathVariable("page") final int page, @PathVariable("size") final int size) {
        return customerService.findPaginated(page, size);
    }
}

package com.mesut.service;

import com.mesut.dto.ResponseObject;
import com.mesut.model.Address;
import com.mesut.model.ApiBaseException;
import com.mesut.model.Customer;
import com.mesut.repository.ICustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;


@Service
public class CustomerService {


    Logger logger= LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    ICustomerRepository customerRepository;


    public Customer getCustomer(Long pId) {
        System.out.println("customer start.");
        if (pId.equals(0L)) {
            throw new ApiBaseException("1", "no customer is not exist");
        } else if (pId.equals(1L)) {
            Customer cc = null;
            cc.toString(); //TODO: null point Exception.
        }

        Customer customer = new Customer(pId, "mesut", "Zincir", 1, 1, 2982, "UK",
                "7345676543", null, null, new ArrayList<>());
        Address address1 = new Address(3L, "UK", "POPLAR", "LONDON", "E14", customer, null, null);
        customer.getAddressList().add(address1);
        Address address2 = new Address(5L, "UK", "BECTON", "LONDON", "E03", customer, null, null);
        customer.getAddressList().add(address2);

        logger.debug("customer id"+pId, customer);

        return customer;
    }

    public Page<Customer> findPaginated(final int page, final int size) {
        Pageable sortedByName =
                PageRequest.of(page, size, Sort.by("name"));
        return customerRepository.findAll(sortedByName);
    }
}

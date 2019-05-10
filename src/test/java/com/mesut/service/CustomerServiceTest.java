package com.mesut.service;

import com.mesut.model.Address;
import com.mesut.model.Customer;
import com.mesut.repository.ICustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;


@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @MockBean
    ICustomerRepository customerRepository;

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public CustomerService employeeService() {
            return new CustomerService();
        }
    }


    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        Customer customer = new Customer(2L, "mesut", "Zincir", 1, 1, 2982, "UK",
                "7345676543", null, null, new ArrayList<>());
        Address address1 = new Address(3L, "UK", "POPLAR", "LONDON", "E14", customer, null, null);
        customer.getAddressList().add(address1);
        Address address2 = new Address(5L, "UK", "BECTON", "LONDON", "E03", customer, null, null);
        customer.getAddressList().add(address2);
        Mockito.when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getCustomer() {
        Customer customer=customerService.getCustomer(2L);
        Assertions.assertThat(customer.getId()).isEqualTo(2L);
    }

    private final Object NULL = null;

    @Test
    @DisplayName("Should be null")
    void shouldBeNull() {
        Assertions.assertThat(NULL).isNull();
    }
}
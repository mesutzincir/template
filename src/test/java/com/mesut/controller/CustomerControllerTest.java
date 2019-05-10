package com.mesut.controller;

import com.mesut.TemplateApplication;
import com.mesut.model.Address;
import com.mesut.model.Customer;
import com.mesut.service.CustomerService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@RunWith(SpringRunner.class)
//@WebMvcTest //(CustomerController.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = TemplateApplication.class)
@AutoConfigureMockMvc
// @TestPropertySource(locations = "classpath:application-integrationtest.properties")
@AutoConfigureTestDatabase
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService service;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("getCustomerById_test")
    void getCustomerById_test() throws Exception {
        {

            Customer customer = new Customer(2L, "mesut", "Zincir", 1, 1, 2982, "UK",
                    "7345676543", null, null, new ArrayList<>());
            Address address1 = new Address(3L, "UK", "POPLAR", "LONDON", "E14", customer, null, null);
            customer.getAddressList().add(address1);
            Address address2 = new Address(5L, "UK", "BECTON", "LONDON", "E03", customer, null, null);
            customer.getAddressList().add(address2);
            Mockito.when(service.getCustomer(customer.getId())).thenReturn(customer);


            mvc.perform(get("/customer/2")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    //.andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$.responseObject.name", is(customer.getName())));
        }
    }
}
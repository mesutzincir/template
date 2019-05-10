package com.mesut;

import com.mesut.model.Address;
import com.mesut.model.Customer;
import com.mesut.repository.ICustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@SpringBootApplication
public class TemplateApplication {

    public static void main(String[] args) {

        System.out.println("max:"+LocalTime.MAX);
        System.out.println("min:"+LocalTime.MIN);
        System.out.println("midnight:"+LocalTime.MIDNIGHT);
        System.out.println("now:"+LocalTime.now());
        System.out.println("noon:"+LocalTime.NOON);
        System.out.println("date max:"+ LocalDate.MAX);
        System.out.println("date min:"+LocalDate.MIN);

        System.out.println("date now:"+LocalDate.now());
        System.out.println("localdatetime max:"+ LocalDateTime.MAX);
        System.out.println("localdatetime min:"+ LocalDateTime.MIN);
        System.out.println("localdatetime now:"+ LocalDateTime.now());

        LocalDate today= LocalDate.now();
        System.out.println("localdatetime today max now:"+ LocalDateTime.of(today, LocalTime.MAX));
        System.out.println("localdatetime today min now:"+ LocalDateTime.of(today, LocalTime.MIN));

        SpringApplication.run(TemplateApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(
            ICustomerRepository customerRepository
    )
    {
        return (args )-> {

            Customer customer = new Customer(2L, "mesut", "Zincir", 1, 1, 2982, "UK",
                    "7345676543", null, null, new ArrayList<>());
            Address address1 = new Address(3L, "UK", "POPLAR", "LONDON", "E14", customer, null, null);
            customer.getAddressList().add(address1);
            Address address2 = new Address(5L, "UK", "BECTON", "LONDON", "E03", customer, null, null);
            customer.getAddressList().add(address2);
            customerRepository.save(customer);

            customer = new Customer(3L, "ayse", "Zincir", 1, 1, 2982, "UK",
                    "7345676543", null, null, new ArrayList<>());
             address1 = new Address(6L, "UK", "POPLAR", "LONDON", "E14", customer, null, null);
            customer.getAddressList().add(address1);
             address2 = new Address(7L, "UK", "BECTON", "LONDON", "E03", customer, null, null);
            customer.getAddressList().add(address2);
            customerRepository.save(customer);

            customer = new Customer(4L, "akif", "Zincir", 1, 1, 2982, "UK",
                    "7345676543", null, null, new ArrayList<>());
            address1 = new Address(8L, "UK", "POPLAR", "LONDON", "E14", customer, null, null);
            customer.getAddressList().add(address1);
            address2 = new Address(9L, "UK", "BECTON", "LONDON", "E03", customer, null, null);
            customer.getAddressList().add(address2);
            customerRepository.save(customer);
        };
    }
}

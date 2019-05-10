package com.mesut.repository;

import com.mesut.model.Customer;
import org.hibernate.CustomEntityDirtinessStrategy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {


}

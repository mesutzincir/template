package com.mesut.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    Long id;
    String country;
    String address;
    String city;
    String postalCode;
    @JsonIgnore
    @ManyToOne
    Customer customer;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
}

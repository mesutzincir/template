package com.mesut.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    Long id; // same user id
    String name;
    String lastName;
    int birthDateDay;
    int birthDateMonth;
    int birthDateYear;
    String phoneCountry;
    String phoneNumber;

    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    @Transient
    List<Address> addressList;
}


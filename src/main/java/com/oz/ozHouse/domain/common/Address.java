package com.oz.ozHouse.domain.common;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Address {
    private String postcode;
    private String city;
    private String street;
    private String zipcode;
}
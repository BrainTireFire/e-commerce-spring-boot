package com.tengo.ecommerce.customer;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {

}

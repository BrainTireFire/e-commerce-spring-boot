package com.tengo.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer first name is required")
        @NotBlank(message = "Customer first name is required")
        @NotEmpty(message = "Customer first name is required")
        String firstName,
        @NotNull(message = "Customer last name is required")
        @NotBlank(message = "Customer last name is required")
        @NotEmpty(message = "Customer last name is required")
        String lastName,
        @NotNull(message = "Customer email is required")
        @NotBlank(message = "Customer email is required")
        @NotEmpty(message = "Customer email is required")
        @Email(message = "Customer email is invalid")
        String email,
        Address address
) {
}

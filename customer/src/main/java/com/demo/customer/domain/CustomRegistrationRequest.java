package com.demo.customer.domain;

public record CustomRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}

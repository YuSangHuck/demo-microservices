package com.demo.customer.service;

import com.demo.customer.domain.*;
import com.demo.customer.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
//        todo: check if email is valid
//        todo: check if email is not taken
//        todo: store customer in db
    }
}
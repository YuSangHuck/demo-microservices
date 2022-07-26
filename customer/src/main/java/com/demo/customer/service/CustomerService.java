package com.demo.customer.service;

import com.demo.customer.domain.*;
import com.demo.customer.domain.Customer;
import com.demo.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
//        todo: check if email is valid
//        todo: check if email is not taken
        customerRepository.save(customer);
    }
}

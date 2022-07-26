package com.demo.customer.controller;

import com.demo.customer.domain.CustomRegistrationRequest;
import com.demo.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomRegistrationRequest customRegistrationRequest) {
        log.info("new customer registration {}", customRegistrationRequest);
        customerService.registerCustomer(customRegistrationRequest);
    }
}

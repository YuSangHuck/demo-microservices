package com.demo.customer.service;

import com.demo.clients.fraud.FraudCheckResponse;
import com.demo.clients.fraud.FraudClient;
import com.demo.customer.domain.CustomRegistrationRequest;
import com.demo.customer.domain.Customer;
import com.demo.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
//    RestTemplate type의 bean이 없다는 에러 뜸 -> RestTemplate type의 bean을 만들어서 spring에서 관리해줘야함
//    모듈 루트에 Config 파일 만들자
    private final FraudClient fraudClient;

    public void registerCustomer(CustomRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
//        todo: check if email is valid
//        todo: check if email is not taken
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}

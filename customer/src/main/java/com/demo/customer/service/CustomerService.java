package com.demo.customer.service;

import com.demo.customer.domain.*;
import com.demo.customer.domain.Customer;
import com.demo.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
//    RestTemplate type의 bean이 없다는 에러 뜸 -> RestTemplate type의 bean을 만들어서 spring에서 관리해줘야함
//    모듈 루트에 Config 파일 만들자
    private final RestTemplate restTemplate; 

    public void registerCustomer(CustomRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
//        todo: check if email is valid
//        todo: check if email is not taken
        customerRepository.saveAndFlush(customer);
        String url = "http://FRAUD/api/v1/fraud-check/{customerId}"; // 뒤에서 인자로 넣어줄거임
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(url, FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}

package com.demo.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // @Component이므로 ComponentScan의 대상
public class CustomerConfig {
    @Bean
    @LoadBalanced // eureka에 등록된 application name으로
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

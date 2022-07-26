package com.demo.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // @Component이므로 ComponentScan의 대상
public class CustomerConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

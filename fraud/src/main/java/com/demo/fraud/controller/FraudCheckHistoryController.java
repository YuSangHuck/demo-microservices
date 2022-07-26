package com.demo.fraud.controller;

import com.demo.fraud.domain.FraudCheckResponse;
import com.demo.fraud.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudCheckHistoryController {
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudSter(@PathVariable Long customerId) {
        boolean isFraudlentCustomer = fraudCheckHistoryService.isFraudlentCustomer(customerId);

        return new FraudCheckResponse(isFraudlentCustomer);
    }
}

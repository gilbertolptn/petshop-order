package com.example.petshop.order.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountClientImpl implements AccountClient {

    private final RestTemplate restTemplate;
    private final String statusUrl;

    public AccountClientImpl(RestTemplateBuilder restTemplateBuilder,
                             @Value("${statusUrl}") String statusUrl) {
        this.restTemplate = restTemplateBuilder
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.statusUrl = statusUrl;
    }

    @Override
    public boolean isAcountStatusRegular(Long accountId) {
        var status = restTemplate.getForObject(statusUrl, AccountStatus.class, accountId);
        return status != null && status.getStatus().equalsIgnoreCase("regular");
    }
}

package com.iexapis.cloud.integration.concurrencystock.api.stock;

import com.iexapis.cloud.integration.concurrencystock.model.StockModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockClientProvider implements StockClientApi {

    @Value("${app.integration.api.iexcloud.url.stock}")
    private String stockUrl;

    @Value("${app.integration.api.iexcloud.token}")
    private String token;

    private final RestTemplate restTemplate;

    @Scheduled(fixedRate = 1000)
    @Override
    public Collection<StockModel> getStocks() {
        String url = stockUrl + "?token=" + token;
        ParameterizedTypeReference<List<StockModel>> typeReference = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<StockModel>> response = restTemplate.exchange(url, HttpMethod.GET, null, typeReference);
        return response.getBody();
    }
}


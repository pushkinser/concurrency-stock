package com.iexapis.cloud.integration.concurrencystock.adapter.rest.client;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quotes;
import com.iexapis.cloud.integration.concurrencystock.application.port.input.QuotesClientApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * StockController
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
@Controller
public class QuotesClientProvider implements QuotesClientApi {

    private final RestTemplate restTemplate;

    private final String urlSafety;

    private final String stockNamePlaceholder;

    public QuotesClientProvider(RestTemplate restTemplate,
                                @Value("${app.integration.api.iexcloud.url.quotes}") String url,
                                @Value("${app.integration.api.iexcloud.url.stockNameKey}") String stockNamePlaceholder,
                                @Value("${app.integration.api.iexcloud.token}") String token) {
        this.restTemplate = restTemplate;
        this.stockNamePlaceholder = stockNamePlaceholder;
        this.urlSafety = url + "?token=" + token;
    }

    @Override
    public Quotes getQuotesByStocks(String stockName) {
        String completeUrl = urlSafety.replace(stockNamePlaceholder, stockName);
        ResponseEntity<Quotes> quotesModelResponse = restTemplate
                .getForEntity(completeUrl, Quotes.class);
        return quotesModelResponse.getBody();
    }

}

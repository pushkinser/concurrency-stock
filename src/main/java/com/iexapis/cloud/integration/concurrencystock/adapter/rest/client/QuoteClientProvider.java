package com.iexapis.cloud.integration.concurrencystock.adapter.rest.client;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;
import com.iexapis.cloud.integration.concurrencystock.application.port.input.QuoteClientApi;
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
public class QuoteClientProvider implements QuoteClientApi {

    private final RestTemplate restTemplate;

    private final String urlSafety;

    private final String stockNamePlaceholder;

    public QuoteClientProvider(RestTemplate restTemplate,
                               @Value("${app.integration.api.iexcloud.url.quotes}") String url,
                               @Value("${app.integration.api.iexcloud.url.stockNameKey}") String stockNamePlaceholder,
                               @Value("${app.integration.api.iexcloud.token}") String token) {
        this.restTemplate = restTemplate;
        this.stockNamePlaceholder = stockNamePlaceholder;
        this.urlSafety = url + "?token=" + token;
    }

    @Override
    public Quote getQuotesByStocks(String stockName) {
        String completeUrl = urlSafety.replace(stockNamePlaceholder, stockName);
        ResponseEntity<Quote> quotesModelResponse = restTemplate
                .getForEntity(completeUrl, Quote.class);
        return quotesModelResponse.getBody();
    }

}

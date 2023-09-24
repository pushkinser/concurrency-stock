package com.iexapis.cloud.integration.concurrencystock.adapter.rest.client;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;
import com.iexapis.cloud.integration.concurrencystock.application.port.input.QuoteClientApi;
import com.iexapis.cloud.integration.concurrencystock.application.port.input.QuoteClientRpsFrequencyApi;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.Semaphore;

@Component
@RequiredArgsConstructor
public class QuoteClientRpsFrequencyProvider implements QuoteClientRpsFrequencyApi {

    private final QuoteClientApi quoteClientApi;

    @Value("${app.integration.api.iexcloud.maxRps}")
    private int rps;

    private Semaphore semaphore;

    @PostConstruct
    void init() {
        semaphore = new Semaphore(rps);
    }

    @Override
    public Quote getQuotes(String stockName) {
        Quote quote;
        try {
            semaphore.acquire();

            quote = quoteClientApi.getQuotesByStocks(stockName);

            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return quote;
    }
}

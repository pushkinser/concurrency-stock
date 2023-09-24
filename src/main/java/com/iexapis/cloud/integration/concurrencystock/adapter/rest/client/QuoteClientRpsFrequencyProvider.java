package com.iexapis.cloud.integration.concurrencystock.adapter.rest.client;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;
import com.iexapis.cloud.integration.concurrencystock.application.port.input.QuoteClientApi;
import com.iexapis.cloud.integration.concurrencystock.application.port.input.QuoteClientRpsFrequencyApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.Semaphore;

@Component
@RequiredArgsConstructor
public class QuoteClientRpsFrequencyProvider implements QuoteClientRpsFrequencyApi {

    private static final int MAX_REQUESTS_PER_SECOND = 5;
    private final QuoteClientApi quoteClientApi;
    private final Semaphore semaphore = new Semaphore(MAX_REQUESTS_PER_SECOND);

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

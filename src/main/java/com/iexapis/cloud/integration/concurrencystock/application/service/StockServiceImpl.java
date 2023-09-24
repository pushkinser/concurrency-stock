package com.iexapis.cloud.integration.concurrencystock.application.service;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;
import com.iexapis.cloud.integration.concurrencystock.application.port.persistence.nosql.ServicePersistenceApi;
import com.iexapis.cloud.integration.concurrencystock.application.port.rest.QuoteClientRpsFrequencyApi;
import com.iexapis.cloud.integration.concurrencystock.application.port.rest.StockClientApi;
import com.iexapis.cloud.integration.concurrencystock.adapter.persistence.inner.QuoteStorage;
import com.iexapis.cloud.integration.concurrencystock.adapter.persistence.inner.StockStorage;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * StockServiceImpl
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockStorage stockStorage;

    private final StockClientApi stockClientApi;

    private final QuoteClientRpsFrequencyApi quoteClientRpsFrequencyApi;

    private final QuoteStorage quoteStorage;

    private final ServicePersistenceApi<Quote> servicePersistenceApi;

    @PostConstruct
    public void pullStocks() {
        stockStorage.setList(stockClientApi.getStocks());
    }

    @Scheduled(fixedRate = 10000)
    private void invokeQuote() {
        stockStorage.getList().parallelStream().forEach(stock -> {
            Quote quotesByStocks = quoteClientRpsFrequencyApi.getQuotes(stock.getSymbol());
            quoteStorage.addToList(quotesByStocks);
            servicePersistenceApi.createOrUpdate(quotesByStocks);
        });
    }
}

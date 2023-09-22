package com.iexapis.cloud.integration.concurrencystock.service.Impl;

import com.iexapis.cloud.integration.concurrencystock.application.port.input.QuoteClientApi;
import com.iexapis.cloud.integration.concurrencystock.application.port.input.StockClientApi;
import com.iexapis.cloud.integration.concurrencystock.service.StockService;
import jakarta.annotation.PostConstruct;
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
public class StockServiceImpl implements StockService {

    private final StockStorage stockStorage;

    private final StockClientApi stockClientApi;

    private final QuoteClientApi quoteClientapi;

    private final QuoteStorage quoteStorage;

    public StockServiceImpl(StockStorage stockStorage,
                            QuoteStorage quoteStorage,
                            StockClientApi stockClientProvider,
                            QuoteClientApi quoteClientProvider) {
        this.stockStorage = stockStorage;
        this.quoteStorage = quoteStorage;
        this.stockClientApi = stockClientProvider;
        this.quoteClientapi = quoteClientProvider;
    }

    @PostConstruct
    public void pullStocks() {
        stockStorage.setList(stockClientApi.getStocks());
    }

    @Scheduled(fixedRate = 10000)
    private void invokeQuote() {
        stockStorage.getList().parallelStream().forEach(stock ->
                quoteStorage.addToList(quoteClientapi.getQuotesByStocks(stock.getSymbol())));
    }
}

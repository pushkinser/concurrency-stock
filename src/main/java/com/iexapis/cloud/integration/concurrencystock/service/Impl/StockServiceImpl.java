package com.iexapis.cloud.integration.concurrencystock.service.Impl;

import com.iexapis.cloud.integration.concurrencystock.application.port.input.StockClientApi;
import com.iexapis.cloud.integration.concurrencystock.service.StockService;
import jakarta.annotation.PostConstruct;
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

    private final StockClientApi stockClientProvider;

    public StockServiceImpl(StockStorage stockStorage, StockClientApi stockClientProvider) {
        this.stockStorage = stockStorage;
        this.stockClientProvider = stockClientProvider;
    }

    @PostConstruct
    public void pullStocks() {
        stockStorage.setStocksList(stockClientProvider.getStocks());
    }
}

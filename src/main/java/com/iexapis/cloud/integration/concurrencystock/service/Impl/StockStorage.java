package com.iexapis.cloud.integration.concurrencystock.service.Impl;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Stock;
import com.iexapis.cloud.integration.concurrencystock.service.Storage;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * StocksStorage
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
@Component
public class StockStorage implements Storage<Stock> {

    CopyOnWriteArrayList<Stock> stockList = new CopyOnWriteArrayList<>();

    @Override
    public void setStocksList(Collection<Stock> stockList) {
        this.stockList = new CopyOnWriteArrayList<>(stockList);
    }

    @Override
    public void addToStockList(Collection<Stock> stockList) {
        this.stockList.addAll(new CopyOnWriteArrayList<>(stockList));
    }

    @Override
    public void addToStockList(Stock stock) {
        this.stockList.add(stock);
    }

}

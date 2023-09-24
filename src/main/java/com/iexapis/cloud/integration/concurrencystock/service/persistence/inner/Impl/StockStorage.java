package com.iexapis.cloud.integration.concurrencystock.service.persistence.inner.Impl;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Stock;
import com.iexapis.cloud.integration.concurrencystock.service.persistence.inner.Storage;
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
    public void setList(Collection<Stock> stockList) {
        this.stockList = new CopyOnWriteArrayList<>(stockList);
    }

    @Override
    public void addToList(Collection<Stock> stockList) {
        this.stockList.addAll(new CopyOnWriteArrayList<>(stockList));
    }

    @Override
    public void addToList(Stock stock) {
        this.stockList.add(stock);
    }

    @Override
    public CopyOnWriteArrayList<Stock> getList() {
        return stockList;
    }
}

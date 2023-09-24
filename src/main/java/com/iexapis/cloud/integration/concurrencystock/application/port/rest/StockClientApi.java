package com.iexapis.cloud.integration.concurrencystock.application.port.rest;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Stock;

import java.util.Collection;

public interface StockClientApi {

    Collection<Stock> getStocks();
}

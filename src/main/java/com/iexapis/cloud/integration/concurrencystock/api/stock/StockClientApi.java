package com.iexapis.cloud.integration.concurrencystock.api.stock;

import com.iexapis.cloud.integration.concurrencystock.model.StockModel;

import java.util.Collection;

public interface StockClientApi {

    Collection<StockModel> getStocks();
}

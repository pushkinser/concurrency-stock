package com.iexapis.cloud.integration.concurrencystock.application.port.rest;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;

/**
 * QuotesController
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
public interface QuoteClientApi {
    Quote getQuotesByStocks(String stockName);
}

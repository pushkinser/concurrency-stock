package com.iexapis.cloud.integration.concurrencystock.application.port.input;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quotes;

/**
 * QuotesController
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
public interface QuotesClientApi {
    Quotes getQuotesByStocks(String stockName);
}

package com.iexapis.cloud.integration.concurrencystock.application.port.input;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;

public interface QuoteClientRpsFrequencyApi {
    Quote getQuotes(String stockName);
}

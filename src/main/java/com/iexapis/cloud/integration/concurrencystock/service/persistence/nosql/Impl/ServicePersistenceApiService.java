package com.iexapis.cloud.integration.concurrencystock.service.persistence.nosql.Impl;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;
import com.iexapis.cloud.integration.concurrencystock.application.port.persistence.QuoteNoSqlApi;
import com.iexapis.cloud.integration.concurrencystock.application.port.persistence.entity.QuoteDocument;
import com.iexapis.cloud.integration.concurrencystock.service.persistence.nosql.ServicePersistenceApi;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * QuotePersistenceService
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 24.09.2023
 */
@Service
public class ServicePersistenceApiService implements ServicePersistenceApi<Quote> {

    private final QuoteNoSqlApi quoteNoSqlApi;

    public ServicePersistenceApiService(QuoteNoSqlApi quoteNoSqlApi) {
        this.quoteNoSqlApi = quoteNoSqlApi;
    }

    @Override
    public void saveQuote(Quote quote) {
        QuoteDocument quoteDocument = QuoteDocument.builder()
                .companyId(UUID.randomUUID())
                .latestPrice(quote.getLatestPrice())
                .companyName(quote.getCompanyName())
                .build();
        quoteNoSqlApi.save(quoteDocument);
    }

}

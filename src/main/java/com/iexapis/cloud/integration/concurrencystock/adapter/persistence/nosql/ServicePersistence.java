package com.iexapis.cloud.integration.concurrencystock.adapter.persistence.nosql;

import com.iexapis.cloud.integration.concurrencystock.adapter.persistence.nosql.entity.QuoteDocument;
import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;
import com.iexapis.cloud.integration.concurrencystock.application.port.persistence.nosql.QuoteNoSqlApi;
import com.iexapis.cloud.integration.concurrencystock.application.port.persistence.nosql.ServicePersistenceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * QuotePersistenceService
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 24.09.2023
 */
@Service
@RequiredArgsConstructor
public class ServicePersistence implements ServicePersistenceApi<Quote> {

    private final QuoteNoSqlApi quoteNoSqlApi;

    @Override
    public void createOrUpdate(Quote quote) {
        Optional<QuoteDocument> optionalQuoteDocument = quoteNoSqlApi.findByCompanyName(quote.getCompanyName());
        QuoteDocument quoteDocument;
        if (optionalQuoteDocument.isEmpty()) {
            quoteDocument = QuoteDocument.builder()
                    .companyId(UUID.randomUUID())
                    .latestPrice(quote.getLatestPrice())
                    .companyName(quote.getCompanyName())
                    .build();
        } else {
            quoteDocument = optionalQuoteDocument.get();
            quote.setLatestPrice(quote.getLatestPrice());
        }
        quoteNoSqlApi.save(quoteDocument);
    }

}

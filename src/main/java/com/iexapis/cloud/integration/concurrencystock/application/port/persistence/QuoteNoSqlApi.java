package com.iexapis.cloud.integration.concurrencystock.application.port.persistence;

import com.iexapis.cloud.integration.concurrencystock.application.port.persistence.entity.QuoteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * NoSqlApi
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 24.09.2023
 */
@Repository
public interface QuoteNoSqlApi extends MongoRepository<QuoteDocument, Long> {
}

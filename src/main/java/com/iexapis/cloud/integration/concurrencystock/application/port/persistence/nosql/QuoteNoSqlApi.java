package com.iexapis.cloud.integration.concurrencystock.application.port.persistence.nosql;

import com.iexapis.cloud.integration.concurrencystock.adapter.persistence.nosql.entity.QuoteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * NoSqlApi
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 24.09.2023
 */
@Repository
public interface QuoteNoSqlApi extends MongoRepository<QuoteDocument, UUID> {

    Optional<QuoteDocument> findByCompanyName(String companyName);

}

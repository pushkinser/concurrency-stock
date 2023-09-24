package com.iexapis.cloud.integration.concurrencystock.service.persistence.nosql;

/**
 * QuotePersistence
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 24.09.2023
 */
public interface ServicePersistenceApi<T> {
    void saveQuote(T model);
}

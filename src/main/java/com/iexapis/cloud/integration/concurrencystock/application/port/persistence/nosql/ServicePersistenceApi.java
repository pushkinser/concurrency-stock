package com.iexapis.cloud.integration.concurrencystock.application.port.persistence.nosql;

/**
 * QuotePersistence
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 24.09.2023
 */
public interface ServicePersistenceApi<T> {
    void createOrUpdate(T model);
}

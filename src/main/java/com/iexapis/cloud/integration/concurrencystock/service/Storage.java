package com.iexapis.cloud.integration.concurrencystock.service;

import java.util.Collection;

/**
 * Storage
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
public interface Storage<T> {
    void setStocksList(Collection<T> entityList);

    void addToStockList(Collection<T> entityList);

    void addToStockList(T entity);
}

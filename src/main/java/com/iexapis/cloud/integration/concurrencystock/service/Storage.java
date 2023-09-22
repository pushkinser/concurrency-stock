package com.iexapis.cloud.integration.concurrencystock.service;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Storage
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
public interface Storage<T> {
    void setList(Collection<T> entityList);

    void addToList(Collection<T> entityList);

    void addToList(T entity);

    CopyOnWriteArrayList<T> getList();
}

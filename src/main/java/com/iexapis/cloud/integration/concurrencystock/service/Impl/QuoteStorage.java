package com.iexapis.cloud.integration.concurrencystock.service.Impl;

import com.iexapis.cloud.integration.concurrencystock.adapter.rest.model.Quote;
import com.iexapis.cloud.integration.concurrencystock.service.Storage;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * QuoteStorage
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
@Component
public class QuoteStorage implements Storage<Quote> {

    CopyOnWriteArrayList<Quote> quoteList = new CopyOnWriteArrayList<>();

    @Override
    public void setList(Collection<Quote> entityList) {
        this.quoteList = new CopyOnWriteArrayList<>(entityList);
    }

    @Override
    public void addToList(Collection<Quote> entityList) {
        this.quoteList.addAll(new CopyOnWriteArrayList<>(entityList));
    }

    @Override
    public void addToList(Quote entity) {
        this.quoteList.add(entity);
    }

    @Override
    public CopyOnWriteArrayList<Quote> getList() {
        return quoteList;
    }
}

package com.iexapis.cloud.integration.concurrencystock.in.rest;

import com.iexapis.cloud.integration.concurrencystock.model.QuotesModel;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * QuotesController
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
public interface QuotesController {
    QuotesModel getQuotesByStocks(String stockName);
}
